/********************************************************************************
** Form generated from reading UI file 'dinfobolas.ui'
**
** Created by: Qt User Interface Compiler version 5.12.8
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_DINFOBOLAS_H
#define UI_DINFOBOLAS_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QDialogButtonBox>
#include <QtWidgets/QLabel>
#include <QtWidgets/QListWidget>

QT_BEGIN_NAMESPACE

class Ui_DInfoBolas
{
public:
    QDialogButtonBox *buttonBox;
    QListWidget *listaBolas;
    QLabel *txt;

    void setupUi(QDialog *DInfoBolas)
    {
        if (DInfoBolas->objectName().isEmpty())
            DInfoBolas->setObjectName(QString::fromUtf8("DInfoBolas"));
        DInfoBolas->resize(609, 394);
        buttonBox = new QDialogButtonBox(DInfoBolas);
        buttonBox->setObjectName(QString::fromUtf8("buttonBox"));
        buttonBox->setGeometry(QRect(260, 350, 341, 32));
        buttonBox->setOrientation(Qt::Horizontal);
        buttonBox->setStandardButtons(QDialogButtonBox::Cancel|QDialogButtonBox::Ok);
        listaBolas = new QListWidget(DInfoBolas);
        listaBolas->setObjectName(QString::fromUtf8("listaBolas"));
        listaBolas->setGeometry(QRect(10, 40, 591, 301));
        QFont font;
        font.setPointSize(12);
        listaBolas->setFont(font);
        txt = new QLabel(DInfoBolas);
        txt->setObjectName(QString::fromUtf8("txt"));
        txt->setGeometry(QRect(20, 10, 571, 20));
        QFont font1;
        font1.setPointSize(13);
        font1.setBold(true);
        font1.setWeight(75);
        txt->setFont(font1);
        txt->setAlignment(Qt::AlignCenter);

        retranslateUi(DInfoBolas);
        QObject::connect(buttonBox, SIGNAL(accepted()), DInfoBolas, SLOT(accept()));
        QObject::connect(buttonBox, SIGNAL(rejected()), DInfoBolas, SLOT(reject()));

        QMetaObject::connectSlotsByName(DInfoBolas);
    } // setupUi

    void retranslateUi(QDialog *DInfoBolas)
    {
        DInfoBolas->setWindowTitle(QApplication::translate("DInfoBolas", "Dialog", nullptr));
        txt->setText(QApplication::translate("DInfoBolas", "Informacion sobre las bolas", nullptr));
    } // retranslateUi

};

namespace Ui {
    class DInfoBolas: public Ui_DInfoBolas {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_DINFOBOLAS_H
