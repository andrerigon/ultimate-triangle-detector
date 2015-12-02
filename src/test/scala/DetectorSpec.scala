import com.utd.Detector
import org.scalatest.mock.MockitoSugar
import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class DetectorSpec extends FlatSpec with Matchers with MockitoSugar with BeforeAndAfter {


  behavior of "#apply"

  it should "throw error if triangles is invalid" in {
    intercept[IllegalArgumentException] {
      Detector(1, 1, 20)
    }
  }
}
