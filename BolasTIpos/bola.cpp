#include "bola.h"

#include <stdlib.h>

Bola::Bola(float px, float py, float vx, float vy):
    posX(px), posY(py), velX(vy),velY(vy){

    impactos = 0;
    tipo = 1;
    vida = 100;
    nombre = "Michael";
    diametro = 40;
    rebotes = 0;
    especial = false;
    color = QColor(rand()%256, rand()%256, rand()%256);

}

Bola::Bola(){
    impactos = 0;
    tipo = 0;
    vida = 80;
    posX = posY = 400;
    velX = velY = 3.2;
    diametro = 40;
    rebotes = 0;
    especial = false;
    color = QColor(random()%256, random()%256, random()%256);
}


void Bola::slotMover(int anchura, int altura){
    // Aqui tenemos en cuenta la ventana para que cuando la bola llege l final rebote

    if (posX >= (anchura - diametro)){
        velX= - fabs(velX);
        rebotes++;
    } else if (posX < 0 ) {
        velX = fabs(velX);
        rebotes++;
    } else if (posY > (altura - diametro)){
        velY= - fabs(velY);
        rebotes++;
    } else if (posY < 0 ) {
        velY = fabs(velY);
        rebotes++;
    } 
    	
     
    posX = posX + velX ;  
    posY = posY + velY ;
    
}

void Bola::slotPintar(QPainter &pintor){

    if (tipo == 1) {
        pintor.setBrush(color); 
        pintor.drawEllipse(posX,posY, diametro*1 ,diametro*1);
    }

    if (tipo == 2) {
        pintor.setBrush(color); 
        pintor.drawEllipse(posX,posY, diametro*2 ,diametro*2);
    }

    if (tipo == 3) {
        pintor.setBrush(color); 
        pintor.drawEllipse(posX,posY, diametro*3 ,diametro*3);
    }

    if (especial){
        pintor.setBrush(QColor(0,0,0));
        pintor.drawEllipse(posX+10,posY+10, diametro/2 ,diametro/2);
    }

    pintor.drawText(posX - 10, posY + diametro + 15, nombre);
    pintor.drawText(posX, posY, QString::number(vida));
    pintor.drawText(posX-20, posY-20, QString::number(tipo));
}

float Bola::distacia(Bola * otraBola){

    float dist;
    dist = sqrtf( powf( (posX-otraBola->posX),2) + powf((posY-otraBola->posY),2));
    
    return dist;
}

bool Bola::choca(Bola * otraBola){ 

    bool hayColision = false;

    if (this->distacia(otraBola) > diametro){
        return false;
    }
    
    Bola * derecha, *izquierda;

    if (this->posX > otraBola->posX){
        derecha = this;
        izquierda = otraBola;
    }else{
        derecha = otraBola;
        izquierda = this;
    }
    
    if (izquierda->velX > derecha->velX) {
        float aux = derecha->velX;
        derecha->velX = izquierda->velX;
        izquierda->velX = aux;
        hayColision = true;
    }

    Bola * arriba, *abajo;

    if (this->posY > otraBola->posY){
        abajo = this;
        arriba = otraBola;
    }else{
        abajo = otraBola;
        arriba = this;
    }
    
    if (arriba->velY > abajo->velY) {
        float aux = arriba->velY;
        arriba->velY = abajo->velY;
        abajo->velY = aux;
        hayColision = true;
    }

    return hayColision;
    
}