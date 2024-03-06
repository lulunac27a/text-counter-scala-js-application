import org.scalajs.dom.document
import org.scalajs.dom
import com.raquo.laminar.api.L._
case class FormState(
    textContent: String = ""
)
object TextCounterApp {
  private val stateVarForm = Var(FormState())
  private val submitter = Observer[FormState] { state =>
    val textContent = document
      .getElementById("textContent")
      .asInstanceOf[dom.html.TextArea]
      .value
    val characters = textContent.length
    val words = textContent.trim.split("\\s+").length
    val lines = textContent.split("\\n").length
    document.getElementById("textOutput").innerHTML =
      s"Characters: $characters\nWords: $words\nLines: $lines"
  }
  def main(args: Array[String]): Unit = {
    def textCounterContent: HtmlElement = {
      div(
        idAttr := "app",
        h1("Text Counter Application using Laminar"),
        div(
          textArea(idAttr := "textContent", rows := 10, cols := 80),
          button(
            "Update Text Counter Output",
            onClick.preventDefault.mapTo(stateVarForm.now()) --> submitter
          ),
          div(idAttr := "textOutput")
        )
      )
    }
    renderOnDomContentLoaded(document.body, textCounterContent)
  }
}
