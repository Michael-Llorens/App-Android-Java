/********************************************************************************
** Form generated from reading UI file 'widgetbolatipo.ui'
**
** Created by: Qt User Interface Compiler version 5.12.8
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_WIDGETBOLATIPO_H
#define UI_WIDGETBOLATIPO_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QSpinBox>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_WidgetBolaTipo
{
public:
    QLabel *nombreBola;
    QPushButton *botonColor;
    QPushButton *botonParar;
    QLabel *nombreBola_2;
    QLabel *nombreBola_3;
    QLabel *vidasBola;
    QLabel *label;
    QPushButton *btCanbiarTipo1;
    QPushButton *btCanbiarTipo2;
    QPushButton *btCanbiarTipo3;
    QLabel *nombreBola_4;
    QLabel *tipoBola;
    QPushButton *btEliminar;
    QPushButton *btRenombrar;
    QLineEdit *txtNombre;
    QLabel *label_2;
    QLabel *nombreBola_5;
    QLabel *colisionesBola;
    QSpinBox *spVidas;
    QPushButton *btvidas;

    void setupUi(QWidget *WidgetBolaTipo)
    {
        if (WidgetBolaTipo->objectName().isEmpty())
            WidgetBolaTipo->setObjectName(QString::fromUtf8("WidgetBolaTipo"));
        WidgetBolaTipo->resize(193, 441);
        nombreBola = new QLabel(WidgetBolaTipo);
        nombreBola->setObjectName(QString::fromUtf8("nombreBola"));
        nombreBola->setGeometry(QRect(90, 0, 67, 17));
        botonColor = new QPushButton(WidgetBolaTipo);
        botonColor->setObjectName(QString::fromUtf8("botonColor"));
        botonColor->setGeometry(QRect(10, 170, 171, 25));
        botonParar = new QPushButton(WidgetBolaTipo);
        botonParar->setObjectName(QString::fromUtf8("botonParar"));
        botonParar->setGeometry(QRect(10, 140, 171, 25));
        nombreBola_2 = new QLabel(WidgetBolaTipo);
        nombreBola_2->setObjectName(QString::fromUtf8("nombreBola_2"));
        nombreBola_2->setGeometry(QRect(10, 20, 67, 17));
        nombreBola_3 = new QLabel(WidgetBolaTipo);
        nombreBola_3->setObjectName(QString::fromUtf8("nombreBola_3"));
        nombreBola_3->setGeometry(QRect(10, 0, 67, 17));
        vidasBola = new QLabel(WidgetBolaTipo);
        vidasBola->setObjectName(QString::fromUtf8("vidasBola"));
        vidasBola->setGeometry(QRect(90, 20, 67, 17));
        label = new QLabel(WidgetBolaTipo);
        label->setObjectName(QString::fromUtf8("label"));
        label->setGeometry(QRect(10, 320, 181, 20));
        btCanbiarTipo1 = new QPushButton(WidgetBolaTipo);
        btCanbiarTipo1->setObjectName(QString::fromUtf8("btCanbiarTipo1"));
        btCanbiarTipo1->setGeometry(QRect(10, 350, 171, 25));
        btCanbiarTipo2 = new QPushButton(WidgetBolaTipo);
        btCanbiarTipo2->setObjectName(QString::fromUtf8("btCanbiarTipo2"));
        btCanbiarTipo2->setGeometry(QRect(10, 380, 171, 25));
        btCanbiarTipo3 = new QPushButton(WidgetBolaTipo);
        btCanbiarTipo3->setObjectName(QString::fromUtf8("btCanbiarTipo3"));
        btCanbiarTipo3->setGeometry(QRect(10, 410, 171, 25));
        nombreBola_4 = new QLabel(WidgetBolaTipo);
        nombreBola_4->setObjectName(QString::fromUtf8("nombreBola_4"));
        nombreBola_4->setGeometry(QRect(10, 40, 67, 17));
        tipoBola = new QLabel(WidgetBolaTipo);
        tipoBola->setObjectName(QString::fromUtf8("tipoBola"));
        tipoBola->setGeometry(QRect(90, 40, 67, 17));
        btEliminar = new QPushButton(WidgetBolaTipo);
        btEliminar->setObjectName(QString::fromUtf8("btEliminar"));
        btEliminar->setGeometry(QRect(10, 200, 171, 25));
        btRenombrar = new QPushButton(WidgetBolaTipo);
        btRenombrar->setObjectName(QString::fromUtf8("btRenombrar"));
        btRenombrar->setGeometry(QRect(10, 290, 171, 25));
        txtNombre = new QLineEdit(WidgetBolaTipo);
        txtNombre->setObjectName(QString::fromUtf8("txtNombre"));
        txtNombre->setGeometry(QRect(10, 260, 171, 25));
        label_2 = new QLabel(WidgetBolaTipo);
        label_2->setObjectName(QString::fromUtf8("label_2"));
        label_2->setGeometry(QRect(10, 230, 181, 20));
        nombreBola_5 = new QLabel(WidgetBolaTipo);
        nombreBola_5->setObjectName(QString::fromUtf8("nombreBola_5"));
        nombreBola_5->setGeometry(QRect(10, 60, 71, 17));
        colisionesBola = new QLabel(WidgetBolaTipo);
        colisionesBola->setObjectName(QString::fromUtf8("colisionesBola"));
        colisionesBola->setGeometry(QRect(90, 60, 67, 17));
        spVidas = new QSpinBox(WidgetBolaTipo);
        spVidas->setObjectName(QString::fromUtf8("spVidas"));
        spVidas->setGeometry(QRect(10, 90, 61, 41));
        btvidas = new QPushButton(WidgetBolaTipo);
        btvidas->setObjectName(QString::fromUtf8("btvidas"));
        btvidas->setGeometry(QRect(80, 90, 101, 41));

        retranslateUi(WidgetBolaTipo);

        QMetaObject::connectSlotsByName(WidgetBolaTipo);
    } // setupUi

    void retranslateUi(QWidget *WidgetBolaTipo)
    {
        WidgetBolaTipo->setWindowTitle(QApplication::translate("WidgetBolaTipo", "Form", nullptr));
        nombreBola->setText(QApplication::translate("WidgetBolaTipo", "n", nullptr));
        botonColor->setText(QApplication::translate("WidgetBolaTipo", "Color", nullptr));
        botonParar->setText(QApplication::translate("WidgetBolaTipo", "Para Bola", nullptr));
        nombreBola_2->setText(QApplication::translate("WidgetBolaTipo", "Vidas:", nullptr));
        nombreBola_3->setText(QApplication::translate("WidgetBolaTipo", "Nombre:", nullptr));
        vidasBola->setText(QApplication::translate("WidgetBolaTipo", "v", nullptr));
        label->setText(QApplication::translate("WidgetBolaTipo", "Cambiar el tipo de la bola", nullptr));
        btCanbiarTipo1->setText(QApplication::translate("WidgetBolaTipo", "Tipo 1", nullptr));
        btCanbiarTipo2->setText(QApplication::translate("WidgetBolaTipo", "Tipo 2", nullptr));
        btCanbiarTipo3->setText(QApplication::translate("WidgetBolaTipo", "Tipo 3", nullptr));
        nombreBola_4->setText(QApplication::translate("WidgetBolaTipo", "TIpo:", nullptr));
        tipoBola->setText(QApplication::translate("WidgetBolaTipo", "t", nullptr));
        btEliminar->setText(QApplication::translate("WidgetBolaTipo", "Eliminar", nullptr));
        btRenombrar->setText(QApplication::translate("WidgetBolaTipo", "Renombrar", nullptr));
        label_2->setText(QApplication::translate("WidgetBolaTipo", "Renombrar la bola", nullptr));
        nombreBola_5->setText(QApplication::translate("WidgetBolaTipo", "Colisiones:", nullptr));
        colisionesBola->setText(QApplication::translate("WidgetBolaTipo", "c", nullptr));
        btvidas->setText(QApplication::translate("WidgetBolaTipo", "Asignar vida", nullptr));
    } // retranslateUi

};

namespace Ui {
    class WidgetBolaTipo: public Ui_WidgetBolaTipo {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_WIDGETBOLATIPO_H
