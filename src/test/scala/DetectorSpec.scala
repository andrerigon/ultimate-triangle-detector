import com.utd.{TriangleType, Detector}
import TriangleType._
import org.scalatest.mock.MockitoSugar
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class DetectorSpec extends FlatSpec with Matchers with MockitoSugar with BeforeAndAfter {


  behavior of "#apply"

  it should "throw error if triangles is invalid" in {
    intercept[IllegalArgumentException] {
      Detector(1, 1, 20)
    }
  }

  it should "throw error if any size is lower than zero" in {
    intercept[IllegalArgumentException] {
      Detector(1, -1, 0)
    }
  }

  it should "return Equilateral if all length's are equal" in {
      Detector(4, 4, 4) should be(Equilateral)
  }

  it should "return Equilateral if just two length's are equal" in {
    Detector(4, 5, 4) should be(Isosceles)
  }
}
