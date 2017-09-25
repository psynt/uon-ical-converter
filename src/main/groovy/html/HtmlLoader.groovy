package html

import org.jetbrains.annotations.NotNull
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class HtmlLoade {

    Document doc



    HtmlLoade(@NotNull String pathname) {
        doc = Jsoup.parse(new File(pathname), "UTF-8")
    }



}


def ht = new HtmlLoade("/home/junko/Desktop/SWS-MyStudent-TSS.html")
print ht.doc.body().select("table.spreadsheet tr:not(.columnTitles)")