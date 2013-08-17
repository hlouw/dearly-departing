import org.scalatest._
import org.scalatest.matchers.ShouldMatchers

class FeedReaderSpec extends FlatSpec with ShouldMatchers {
  
  trait XMLContent extends FeedReader {
    override val pull =
   """<?xml version="1.0" encoding="utf-8"?>
      <outer>
        <middle>
          <centre id="1">Content</centre>
        </middle>
      </outer>"""
  }
  
  
  "A FeedReader" should "parse an XML feed" in {
    val reader = new FeedReader with XMLContent
    val expected =
      <outer>
        <middle>
          <centre id="1">Content</centre>
        </middle>
      </outer>
    val actual = reader.get
    actual should equal (expected)
  }
}