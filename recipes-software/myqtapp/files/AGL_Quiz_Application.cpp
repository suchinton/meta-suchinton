#include <QApplication>
#include <QLabel>
#include <QPushButton>
#include <QVBoxLayout>

int main(int argc, char *argv[]) {
    QApplication app(argc, argv);
    QLabel label("Hello AGL!!");
    label.setAlignment(Qt::AlignCenter);
    label.setStyleSheet("font-size: 20pt;");

    QVBoxLayout layout;
    layout.addWidget(&label);

    QPushButton button("Test Button");
    button.setStyleSheet("font-size: 15pt");
    QObject::connect(&button, &QPushButton::clicked, [&](){
        if (label.text() == "Hello, This is Suchinton's Demo App!") {
            label.setText("Hello AGL!!");
        } else {
            label.setText("Hello, This is Suchinton's Demo App!");
        }
    });
    layout.addWidget(&button);

    QWidget window;
    window.setLayout(&layout);
    window.show();
    return app.exec();
}
