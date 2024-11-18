#include <QApplication>
#include "mainwindow.h"

int main(int argc, char *argv[])
{
    QApplication app(argc, argv);
    
    MainWindow *ventanaPrincipal = new MainWindow();
    ventanaPrincipal->show();
    return app.exec();
}