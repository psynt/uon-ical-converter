package ical

import html.HtmlLoader
import org.apache.commons.lang3.RandomUtils
import org.jetbrains.annotations.NotNull

class ICalGen {

    def inp;
    def events;

    ICalGen(@NotNull List<List<String>> lectures){
        inp = lectures
    }

    def generateEvents(){
//        prodid('-//Ben Fortuna//iCal4j 1.0//EN')
//        version('2.0')
        inp.each{ List<String> entry ->
            def beghr = entry[3].substring(0,2)
            def begmin
            if (beghr == "9:"){
                beghr = "09"
                begmin = entry[3].substring(2,4)
            } else{
                begmin = entry[3].substring(3,5)
            }
            def endhr = entry[4].substring(0,2)
            def endmin
            if (endhr == "9:"){
                endhr = "09"
                endmin = entry[4].substring(2,4)
            } else {
                endmin = entry[4].substring(4,5)
            }

            def beg = beghr+begmin
            def end = endhr+endmin

            def str =
"""
BEGIN:VEVENT
DTSTART;TZID=Europe/London:20170925T${beg}00
DTEND;TZID=Europe/London:20170925T${end}00
RRULE:FREQ=WEEKLY;COUNT=1;BYDAY=${entry[2].substring(0,2).toUpperCase()}
DTSTAMP:20170925T164430Z
UID:${RandomUtils.nextInt()}
CREATED:20170925T163941Z
LOCATION:${entry[5]}
SUMMARY:${entry[0].substring(0,6)}
END:VEVENT
"""
            println str
        }

    }

}
