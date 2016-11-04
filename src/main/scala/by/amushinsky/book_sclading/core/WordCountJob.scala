package by.amushinsky.book_sclading.core

import com.twitter.scalding.Args
import com.twitter.scalding.Job
import com.twitter.scalding.typed.TypedPipe
import com.twitter.scalding.TextLine
import com.twitter.scalding.source.TypedText

class WordCountJob(args: Args) extends Job(args) {
  TypedPipe.from(TextLine(args("input")))
    .flatMap { tokenize }
    .groupBy { identity }
    .size
    .write(TypedText.tsv[(String, Long)](args("output")))
  
  def tokenize(text: String): Array[String] = {
    text.toLowerCase.replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+")
  }
}