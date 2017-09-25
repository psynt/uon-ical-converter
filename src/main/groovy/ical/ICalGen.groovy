package ical

import html.HtmlLoader
import net.fortuna.ical4j.model.ContentBuilder
import net.fortuna.ical4j.model.property.DtStamp
import org.jetbrains.annotations.NotNull

class ICalGe {

    List<String> inp;

    ICalGe(@NotNull List<String> lectures){
        inp = lectures
    }

    def generate(){
        def builder = new ContentBuilder()
        def cal = builder.calendar(){
            prodid('-//Ben Fortuna//iCal4j 1.0//EN')
            version('2.0')
            vevent() {
                uid('1')
                dtstamp(new DtStamp())
                dtstart('20090810', parameters: parameters() {
                    value('DATE')
                })
                action('DISPLAY')
            }

        }

        print cal
    }

}


def ht = new HtmlLoader("/home/junko/Desktop/SWS-MyStudent-TSS.html")
//print ht.getData()
ht.getData()
def ic = new ICalGe(ht.filterData())
ic.generate()