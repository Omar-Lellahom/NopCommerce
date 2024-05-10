@vendor
Feature: Je souhaite le module vendor
Background: 
Given Je me connect a l application nopcommerce 
When Je clique sur le boutton custmor
And Je clique sur le boutton Vendor
When Je saisier le nom de vendor
And Je clique sur boutton search

@search
Scenario: Je souhaite chercher un vendor
Then le vendor s affiche  dans le tableau

@edit
Scenario: Je souhaite modifer un vendor 
When Je clique sur le boutton editer
And Je modifer les informatios de vendor
And Je clique sur le boutton save 
Then un message de mise ajours s affiche  

 

 
