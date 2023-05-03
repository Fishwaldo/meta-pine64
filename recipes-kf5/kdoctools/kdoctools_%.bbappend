#we need to ensure its always in the work directory as when other packages verify their 
#docbook files, it has hard coded paths to the kdoctools build directory. This needs fixing. 
#do_compile[nostamp] = "1"

DEPENDS += " \
    docbook-xsl-stylesheets-native \
"