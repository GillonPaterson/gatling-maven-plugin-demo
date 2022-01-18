package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class AddSimulation extends Simulation{


  val httpProtocol = http
    .baseUrl("http://localhost:3000") // Here is the root for all relative URLs
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val scn = scenario("Adding requests") // A scenario is a chain of requests and pauses
    .exec(http("a") // Here's an example of a POST request
      .post("/addRole")
      .formParam("""jobRole""", """Test""") // Note the triple double quotes: used in Scala for protecting a whole chain of characters (no need for backslash)
      .formParam("""jobSpec""", """This is suppose to imitate a whole lotta text""")
      .formParam("""jobLink""", """https://aReallyCoolUrl""")
      .formParam("""jobResponsibilities""", """Another thing that is suppose to imitate a whole lotta text""")
      .formParam("""jobBandLevel""", """Associate""")
      .formParam("""jobFamily""", """Engineering"""))

  setUp(scn.inject(atOnceUsers(3)).protocols(httpProtocol))
}
