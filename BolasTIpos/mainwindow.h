#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QPaintEvent>
#include <QAction>
#include <QStringList>
#include <QKeyEvent>

#include "bola.h"
#include "dinformacion.h"
#include "dinfobolas.h"
#include "dcontrolbolas.h"
#include "dcontrolbolastipos.h"
#include "dinfotabla.h"

class MainWindow : public QMainWindow {
    Q_OBJECT

public:
    MainWindow(QWidget* parent = 0);
    void paintEvent (QPaintEvent * event );

    void crearBolas();
    void crearActions();
    void crearMenus();
    void keyPressEvent(QKeyEvent *event);

    QVector<Bola *> bolas;
    Bola * bolaJugador;

    QAction *accionInformacion;
    QAction *accionInfoBolas;
    QAction  *accionDControlBolas;
    QAction  *acciocDInfoTabla;
    QAction  *accionTabWidget;

    DInformacion *dInformacion;
    DInfoBolas *dInfoBolas;
    DControlBolas *dControlBolas;
    DInfoTabla *dInfoTabla;
    DControlBolasTipos *dControlBolasTipo;

    QStringList listaNombres;

public slots:
    void slotTemporizador();
    void slotDinformacion();
    void slotDInfoBolas();
    void slotDControlBolas();
    void slotDInfoTabla();
    void slotDControlBolasTipos();

};

#endif