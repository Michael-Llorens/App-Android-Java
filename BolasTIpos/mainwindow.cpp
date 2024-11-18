#include "mainwindow.h"
#include "dinformacion.h"
#include "dinfobolas.h"
#include "dcontrolbolas.h"
#include "widgetbola.h"
#include "dinfotabla.h"

#include <QPainter>
#include <QTimer>
#include <QDebug>
#include <QMenu>
#include <QMenuBar>
#include <math.h>
#include <stdlib.h>
#include <QMessageBox>

MainWindow::MainWindow(QWidget * parent) : QMainWindow(parent) {

    QTimer *temporizador = new QTimer();
    temporizador->setSingleShot(false);
    temporizador->setInterval(10);
    temporizador->start();

    connect(temporizador,SIGNAL(timeout()), this,SLOT(slotTemporizador()));

    QStringList temp = {"Juan","Andres","Pepe","Anna","Fran","Rocio","Clara","Ruben","Luis","Edgar"};
    listaNombres = temp;

    bolaJugador = NULL;

    crearBolas();
    crearActions();
    crearMenus();

    dInformacion = NULL;
    dInfoBolas = NULL;
    dControlBolas = NULL;
    dControlBolasTipo = NULL;
    dInfoTabla = NULL;

    resize(800,600);
}

void MainWindow::crearBolas(){

    int t = 1;

    int anchura = width();
    int altura = height();

    for (int i = 0; i < 10; i++) {

        if (t == 4){
            t = 1;
        }
        
        Bola *nueva = new Bola();
        nueva->impactos = 0;
        nueva->posX = random() % anchura;
        nueva->posY = random() % altura;
        nueva->velX = ((float)(random() % 10)) / 5 - 1;
        nueva->velY = ((float)(random() % 10)) / 5 - 1;
        nueva->nombre = listaNombres[i % listaNombres.size()];
        nueva->tipo = t;
        bolas.append(nueva);
        t++;
    }

    bolaJugador = new Bola(200,300, 0, 0);
    bolaJugador->color = QColor(255,0,0);
    bolaJugador->especial = true;
}

void MainWindow::slotTemporizador(){

    int anchuraV = width();
    int alturaV = height();

    for (int i = 0; i < bolas.size(); i++){ 
        bolas[i]->slotMover(anchuraV, alturaV);
    }

    for (int i = 0; i < bolas.size(); i++){
        for (int j = 0; j < bolas.size(); j++){
            if (i != j) {
                if (bolas[i]->choca(bolas[j])){
                    bolas[i]->vida = bolas[i]->vida - 1;
                    bolas[j]->vida = bolas[j]->vida - 1;
                    bolas[i]->impactos = bolas[i]->impactos + 1;
                    bolas[j]->impactos = bolas[j]->impactos + 1;
                }
                
            }           
        }        
    }

    for (int i = 0; i < bolas.size(); i++){
        if (bolaJugador->choca(bolas[i])){
            bolas[i]->vida = bolas[i]->vida - 1;
            bolaJugador->vida = bolaJugador->vida - 1;
        }
    }
    
    for (int i = 0; i < bolas.size(); i++){
        if (bolas[i]->vida == 0){
            delete bolas[i];
            bolas.remove(i);
            break;
        }
        
    }
    
    if (bolaJugador->vida == 0){
        delete bolaJugador;
        QMessageBox::information(this, "FIN", "La bola del jugador ha muerto");
        close();
    }
    

    bolaJugador->slotMover(anchuraV,alturaV);
    
    update();
}

void MainWindow::keyPressEvent(QKeyEvent *event){

    int codigo = event->key();

    switch (codigo){
        case Qt::Key_Up:
            bolaJugador->velY = bolaJugador->velY - 0.1;
            break;
        case Qt::Key_Down:
            bolaJugador->velY = bolaJugador->velY + 0.1;
            break;
        case Qt::Key_Right:
            bolaJugador->velX = bolaJugador->velX + 0.1;
            break;
        case Qt::Key_Left:
            bolaJugador->velX = bolaJugador->velX - 0.1;
            break;
    }

}

void MainWindow::paintEvent(QPaintEvent *event){
    QPainter pintor(this);

    for (size_t i = 0; i < bolas.size(); i++){
       bolas[i]->slotPintar(pintor);
    }

    bolaJugador->slotPintar(pintor);
    
}

void MainWindow::crearActions(){
    accionInformacion = new QAction("Informacion");
    connect(accionInformacion,SIGNAL(triggered()), this, SLOT(slotDinformacion()));

    accionInfoBolas = new QAction("Info bolas");
    connect(accionInfoBolas,SIGNAL(triggered()), this, SLOT(slotDInfoBolas())); 

    accionDControlBolas = new QAction("Control de las bolas");
	connect(accionDControlBolas,SIGNAL(triggered()), this, SLOT(slotDControlBolas()));

    acciocDInfoTabla = new QAction("Tabla de info");
    connect(acciocDInfoTabla,SIGNAL(triggered()), this, SLOT(slotDInfoTabla()));

    accionTabWidget = new QAction("Tipos Bolas");
    connect(accionTabWidget,SIGNAL(triggered()), this, SLOT(slotDControlBolasTipos()));
}

void MainWindow::crearMenus() {
    QMenu * menuArchivo;
    menuArchivo = menuBar()->addMenu("Archivo");

    menuArchivo->addAction(accionInformacion);
    menuArchivo->addAction(accionInfoBolas);
    menuArchivo->addAction(accionDControlBolas);
    menuArchivo->addAction(acciocDInfoTabla);

    QMenu * menuBolas;
    menuBolas = menuBar()->addMenu("Bolas");

    menuBolas->addAction(accionTabWidget);

}

void MainWindow::slotDinformacion(){
    int numBolas = bolas.size();

    if (dInformacion == NULL){
        dInformacion = new DInformacion(width(),height(),numBolas);
    }
    dInformacion->show();
}

void MainWindow::slotDInfoBolas(){

    if (dInfoBolas == NULL){
        dInfoBolas = new DInfoBolas(&bolas);
    }
    dInfoBolas->show();
}


void MainWindow::slotDControlBolas(){
// Esta bien pasado el puntero
    if (dControlBolas == NULL){
        dControlBolas = new DControlBolas(&bolas);
    }
    dControlBolas->show();
}

void MainWindow::slotDInfoTabla(){

    if (dInfoTabla == NULL){
        dInfoTabla = new DInfoTabla(&bolas);
    }
    dInfoTabla->show();
}

void MainWindow::slotDControlBolasTipos(){

    if (dControlBolasTipo == NULL){
        dControlBolasTipo = new DControlBolasTipos(&bolas);
    }
    dControlBolasTipo->show();
}