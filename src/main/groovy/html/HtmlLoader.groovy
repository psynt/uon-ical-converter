package html

import org.jetbrains.annotations.NotNull
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

import java.util.stream.Collectors

class HtmlLoader {

    Document doc
    Elements trs


    HtmlLoader(@NotNull String pathname) {
        doc = Jsoup.parse(new File(pathname), "UTF-8")
    }

    def getData(){
        trs = doc.body().select("table.spreadsheet tr:not(.columnTitles)")
    }

    def filterData(){
        trs.stream().map{it.select(":contains(G53)")}.filter{it.size()>0}
                .map{it.select("td:eq(0), td:eq(4), td:eq(5), td:eq(6), td:eq(7), td:eq(9)").eachText()} as List
    }


}