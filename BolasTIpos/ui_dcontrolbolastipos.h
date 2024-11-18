/********************************************************************************
** Form generated from reading UI file 'dcontrolbolastipos.ui'
**
** Created by: Qt User Interface Compiler version 5.12.8
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_DCONTROLBOLASTIPOS_H
#define UI_DCONTROLBOLASTIPOS_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDialogButtonBox>
#include <QtWidgets/QLabel>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QTabWidget>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_DControlBolasTipos
{
public:
    QDialogButtonBox *buttonBox;
    QTabWidget *tabBolas;
    QWidget *tab;
    QWidget *tab_2;
    QPushButton *btTipo1;
    QPushButton *btTipo2;
    QPushButton *btTipo3;
    QLabel *label;
    QLabel *lbTipo;
    QPushButton *btImpactos;
    QPushButton *btImpactosTabla;

    void setupUi(QDialog *DControlBolasTipos)
    {
        if (DControlBolasTipos->objectName().isEmpty())
            DControlBolasTipos->setObjectName(QString::fromUtf8("DControlBolasTipos"));
        DControlBolasTipos->resize(339, 680);
        buttonBox = new QDialogButtonBox(DControlBolasTipos);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setGeometry(QRect(-30, 640, 341, 32));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);
        tabBolas = new QTabWidget(DControlBolasTipos);
        tabBolas->setObjectName(QString::fromUtf8("tabBolas"));
        tabBolas->setGeometry(QRect(20, 40, 301, 481));
        tab = new QWidget();
        tab->setObjectName(QString::fromUtf8("tab"));
        tabBolas->addTab(tab, QString());
        tab_2 = new QWidget();
        tab_2->setObjectName(QString::fromUtf8("tab_2"));
        tabBolas->addTab(tab_2, QString());
        btTipo1 = new QPushButton(DControlBolasTipos);
        btTipo1->setObjectName(QString::fromUtf8("btTipo1"));
        btTipo1->setGeometry(QRect(20, 590, 89, 41));
        btTipo2 = new QPushButton(DControlBolasTipos);
        btTipo2->setObjectName(QString::fromUtf8("btTipo2"));
        btTipo2->setGeometry(QRect(120, 590, 101, 41));
        btTipo3 = new QPushButton(DControlBolasTipos);
        btTipo3->setObjectName(QString::fromUtf8("btTipo3"));
        btTipo3->setGeometry(QRect(230, 590, 89, 41));
        label = new QLabel(DControlBolasTipos);
        label->setObjectName(QString::fromUtf8("label"));
        label->setGeometry(QRect(70, 10, 151, 20));
        QFont font;
        font.setPointSize(12);
        font.setBold(true);
        font.setWeight(75);
        label->setFont(font);
        lbTipo = new QLabel(DControlBolasTipos);
        lbTipo->setObjectName(QString::fromUtf8("lbTipo"));
        lbTipo->setGeometry(QRect(230, 10, 31, 21));
        lbTipo->setFont(font);
        btImpactos = new QPushButton(DControlBolasTipos);
        btImpactos->setObjectName(QString::fromUtf8("btImpactos"));
        btImpactos->setGeometry(QRect(20, 540, 141, 31));
        btImpactosTabla = new QPushButton(DControlBolasTipos);
        btImpactosTabla->setObjectName(QString::fromUtf8("btImpactosTabla"));
        btImpactosTabla->setGeometry(QRect(180, 540, 141, 31));

        retranslateUi(DControlBolasTipos);
        QObject::connect(buttonBox, SIGNAL(accepted()), DControlBolasTipos, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), DControlBolasTipos, SLOT(reject()));

        tabBolas->setCurrentIndex(1);


        QMetaObject::connectSlotsByName(DControlBolasTipos);
    } // setupUi

    void retranslateUi(QDialog *DControlBolasTipos)
    {
        DControlBolasTipos->setWindowTitle(QApplication::translate("DControlBolasTipos", "Dialog", nullptr));
        tabBolas->setTabText(tabBolas->indexOf(tab), QApplication::translate("DControlBolasTipos", "Tab 1", nullptr));
        tabBolas->setTabText(tabBolas->indexOf(tab_2), QApplication::translate("DControlBolasTipos", "Tab 2", nullptr));
        btTipo1->setText(QApplication::translate("DControlBolasTipos", "Tipo 1", nullptr));
        btTipo2->setText(QApplication::translate("DControlBolasTipos", "Tipo 2", nullptr));
        btTipo3->setText(QApplication::translate("DControlBolasTipos", "Tipo 3", nullptr));
        label->setText(QApplication::translate("DControlBolasTipos", "Tipo de las pelotas", nullptr));
        lbTipo->setText(QApplication::translate("DControlBolasTipos", "0", nullptr));
        btImpactos->setText(QApplication::translate("DControlBolasTipos", "Impactos Lista", nullptr));
        btImpactosTabla->setText(QApplication::translate("DControlBolasTipos", "Impactos Tabla", nullptr));
    } // retranslateUi

};

namespace Ui {
    class DControlBolasTipos: public Ui_DControlBolasTipos {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_DCONTROLBOLASTIPOS_H
