#its sip3, not sip
DEPENDS = "qtcharts sip3 sip3-native python3 python3-pyqt5"

RDEPENDS:${PN} = "qtbase qtdeclarative qtquickcontrols2 qtquickcontrols2-mkspecs qtcharts"
RDEPENDS:${PN} += "python3-core sip3 python3-pyqt5"