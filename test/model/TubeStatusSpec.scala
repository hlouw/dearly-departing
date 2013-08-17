package model

import play.api.test._
import play.api.test.Helpers._

import org.specs2.matcher.ShouldMatchers
import org.specs2.mutable._

class TubeStatusSpec extends Specification with ShouldMatchers {

  "The TubeStatus companion object" should {
    "parse a single node" in {
      val statusXML =
        <LineStatus StatusDetails="" ID="1">
          <BranchDisruptions/>
          <Line Name="Central" ID="2"/>
          <Status IsActive="true" Description="Good Service" CssClass="GoodService" ID="GS">
            <StatusType Description="Line" ID="1"/>
          </Status>
        </LineStatus>

      val expected = new TubeStatus("Central", "Good Service")

      val actual = TubeStatus(statusXML)

      actual should be equalTo (expected)
    }

    "parse a list of nodes" in {
      val statusXML =
        <ArrayOfLineStatus xmlns="http://webservices.lul.co.uk/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
          <LineStatus StatusDetails="" ID="1">
            <BranchDisruptions/>
            <Line Name="Central" ID="2"/>
            <Status IsActive="true" Description="Good Service" CssClass="GoodService" ID="GS">
              <StatusType Description="Line" ID="1"/>
            </Status>
          </LineStatus>
          <LineStatus StatusDetails="" ID="0">
            <BranchDisruptions/>
            <Line Name="Bakerloo" ID="1"/>
            <Status IsActive="true" Description="Bad Service" CssClass="GoodService" ID="GS">
              <StatusType Description="Line" ID="1"/>
            </Status>
          </LineStatus>
        </ArrayOfLineStatus>
      
      val expected = new TubeStatus("Central", "Good Service") :: new TubeStatus("Bakerloo", "Bad Service") :: Nil
      
      val actual = TubeStatus.getStatuses(statusXML)
      
      actual should be equalTo (expected)
    }
  }

}