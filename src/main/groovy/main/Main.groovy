package main

import html.HtmlLoader
import ical.ICalGen


def ht = new HtmlLoader("/home/junko/Desktop/SWS-MyStudent-TSS.html")
//print ht.getData()
ht.getData()
def fil = ht.filterData()
println fil.getClass()
fil.each{println it}
println "\n\n"
def ic = new ICalGen(fil)
ic.generateEvents()