package textcounter
import org.scalajs.dom
import org.scalajs.dom.document
object TextCounter {
  def main(args: Array[String]): Unit = {
    val textContent =
      document.getElementById("textContent").asInstanceOf[dom.html.TextArea]
    val updateTextCounter =
      document.getElementById("updateText").asInstanceOf[dom.html.Button]
    val textOutput =
      document.getElementById("textOutput").asInstanceOf[dom.html.Div]
    updateTextCounter.addEventListener(
      "click",
      (e: dom.MouseEvent) => {
        val textInput = textContent.value
        val characters = textInput.length
        val words = textInput.trim.split("\\s+").length
        val lines = textInput.split("\\n").length
        textOutput.textContent =
          s"Characters: $characters\nWords: $words\nLines: $lines"
      }
    )
  }
}
