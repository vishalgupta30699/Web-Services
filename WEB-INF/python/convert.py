import pdfkit 
import sys
z=sys.argv
url=z[1];
pdfkit.from_url(url,'c:/Controlpanel9/webapps/service/WEB-INF/result/'+url.split('.')[1]+'.pdf')