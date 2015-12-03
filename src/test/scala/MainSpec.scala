import java.io.{PrintStream, ByteArrayOutputStream, ByteArrayInputStream}

import com.utd.{TriangleType, Main}
import org.scalatest.mock.MockitoSugar
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class MainSpec extends FlatSpec with Matchers with MockitoSugar with BeforeAndAfter {


  behavior of "main"

  it should "throw error if triangle sides are not numbers" in {
    intercept[IllegalArgumentException] {
      System.setIn(toStream("12 a 12"))
      Main.main(Array())
    }
  }

  it should "throw error if triangle sides are not longs" in {
    intercept[IllegalArgumentException] {
      System.setIn(toStream("12 12.1 12"))
      Main.main(Array())
    }
  }

  it should "throw error if triangle side is missing" in {
    intercept[IllegalArgumentException] {
      System.setIn(toStream("12 12"))
      Main.main(Array())
    }
  }

  it should "parse correct input" in {
    import TriangleType._
    val output = new ByteArrayOutputStream()
    System.setIn(toStream("12 12 12", "2 2 4", "4 5 6"))
    System.setOut(new PrintStream(output))
    Console.withOut(output){
      Main.main(Array())
    }
    val results = new String(output.toByteArray).split("\n").filter(_.nonEmpty).map(TriangleType.withName)
    results should be(Equilateral :: Isosceles :: Scalene :: Nil)
  }

  private def toStream(lines: String*) = new ByteArrayInputStream(lines.mkString("\n").getBytes)

}
