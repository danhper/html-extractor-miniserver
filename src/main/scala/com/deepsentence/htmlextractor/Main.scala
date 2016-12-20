import java.net.URL
import de.l3s.boilerpipe.extractors.ArticleExtractor

import org.http4s.HttpService
import org.http4s.dsl.{GET, Root, Ok, ->, /, OkSyntax}
import org.http4s.server.{Server, ServerApp}
import scalaz.concurrent.Task
import org.http4s.server.blaze.BlazeBuilder


object Main extends ServerApp {
  val extractURLContentService = HttpService {
    case GET -> Root / "extract" / url => {
      val text = ArticleExtractor.INSTANCE.getText(new URL(url))
      Ok(text)
    }
  }

  override def server(args: List[String]): Task[Server] = {
    BlazeBuilder
      .bindHttp(8080, "0.0.0.0")
      .mountService(extractURLContentService, "/")
      .start
  }
}
