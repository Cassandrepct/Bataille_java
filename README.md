# Bataille_java

Ce programme a été codé en une semaine, sans connaissance de base en Java.
Il a été réalisé sur IntelliJ en utilisant Maven, Netty(4.0.0.CR3) et javassist(3.12.1.GA).
Toutes les dépendances ont été ajoutées dans les pom.xml.

But du jeu:
Le but du jeu est d’avoir toutes les cartes en main.
Au début du jeu, chaque joueur reçoit des cartes en 7 et le Roi en valeur.
Chacun leur tour, ils peuvent jouer une carte, la carte la plus forte gagne, et le joueur reçoit les cartes des perdants.

Comment jouer ?
Lancer d’abord le jcoinche-server.jar qui se trouve dans Server/target
Lancer ensuite 4 fois jcoinche-client.jar qui se trouve dans Client/target (il faut au minimum 4 joueurs pour démarrer la partie).
Une fois connecté, rentrez la carte que vous voulez jouer parmi votre main.
Appuyez deux fois sur entrée pour envoyer votre carte.
Une erreur s’affiche si vous ne possédez pas cette carte.

A la fin de la partie, les clients se déconnectent automatiquement.
