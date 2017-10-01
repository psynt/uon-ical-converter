package main

import html.HtmlLoader
import ical.ICalGen

try {
    def ht = new HtmlLoader(args[0])
    ht.getData()
    def fil = ht.filterData()
    def ic = new ICalGen(fil)
    print """BEGIN:VCALENDAR
PRODID:-//Google Inc//Google Calendar 70.9054//EN
VERSION:2.0
CALSCALE:GREGORIAN
X-WR-TIMEZONE:Europe/London
"""
    ic.generateEvents()
    print """
END:VCALENDAR"""
}catch(ArrayIndexOutOfBoundsException ex){
    println "Please provide path to .html file"
}