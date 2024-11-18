#ifndef BOLA_H
#define BOLA_H

#include <math.h>
#include <QPainter>
#include <QColor>

class Bola {

public:
    Bola(float px, float py, float vx, float vy);
    Bola();

    int impactos;
    int tipo;
    int vida;
    int rebotes;
    int diametro;
    float posX, posY;
    float velX, velY;
    QColor color;
    QString nombre;

    bool especial;

    void slotMover(int, int);
    void slotPintar(QPainter &pintor);

    bool choca(Bola * otraBola);
    float distacia(Bola *otraBola);


public slots:
    

};

#endif