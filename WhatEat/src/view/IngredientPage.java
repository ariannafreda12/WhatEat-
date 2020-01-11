package view;

import java.util.ArrayList;

import bean.RecipeBean;
import controller.GraphicController;
import controller.RecipeManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Recipe;

public class IngredientPage {
	
	
	@FXML
	public CheckBox butter;
	@FXML
	public CheckBox cheese;
	@FXML
	public CheckBox chocolate;
	@FXML
	public CheckBox eggs;
	@FXML
	public CheckBox flour;
	@FXML
	public CheckBox honey;
	@FXML
	public CheckBox jam;
	@FXML
	public CheckBox milk;
	@FXML
	public CheckBox oil;
	@FXML
	public CheckBox pasta;
	@FXML
	public CheckBox rice;
	@FXML
	public CheckBox salt;
	@FXML
	public CheckBox sugar;
	@FXML
	public CheckBox water;
	@FXML
	public CheckBox yeast;
	@FXML
	public CheckBox yoghurt;
	@FXML
	public CheckBox ketchup;
	@FXML
	public CheckBox mayonnaise;
	@FXML
	public CheckBox mustard;
	@FXML
	public CheckBox vinegar;
	@FXML
	public CheckBox basil;
	@FXML
	public CheckBox chives;
	@FXML
	public CheckBox coriander;
	@FXML
	public CheckBox dill;
	@FXML
	public CheckBox parsley;
	@FXML
	public CheckBox rosemary;
	@FXML
	public CheckBox sage;
	@FXML
	public CheckBox thyme;
	@FXML
	public CheckBox cinnamon;
	@FXML
	public CheckBox cumin;
	@FXML
	public CheckBox curry;
	@FXML
	public CheckBox nutmeg;
	@FXML
	public CheckBox paprika;
	@FXML
	public CheckBox saffron;
	@FXML
	public CheckBox olives;
	@FXML
	public CheckBox walnuts;
	@FXML
	public CheckBox peanuts;
	@FXML
	public CheckBox nuts;
	@FXML
	public CheckBox artichoke;
	@FXML
	public CheckBox asparagus;
	@FXML
	public CheckBox aubergine;
	@FXML
	public CheckBox avocado;
	@FXML
	public CheckBox beansprouts;
	@FXML
	public CheckBox beetroot;
	@FXML
	public CheckBox broadbeans;
	@FXML
	public CheckBox broccoli;
	@FXML
	public CheckBox cabbage;
	@FXML
	public CheckBox carrot;
	@FXML
	public CheckBox cauliflower;
	@FXML
	public CheckBox celery;
	@FXML
	public CheckBox chillipepper;
	@FXML
	public CheckBox courgette;
	@FXML
	public CheckBox cucumber;
	@FXML
	public CheckBox frenchbeans;
	@FXML
	public CheckBox garlic;
	@FXML
	public CheckBox ginger;
	@FXML
	public CheckBox leek;
	@FXML
	public CheckBox lettuce;
	@FXML
	public CheckBox mushroom;
	@FXML
	public CheckBox onion;
	@FXML
	public CheckBox peas;
	@FXML
	public CheckBox pepper;
	@FXML
	public CheckBox potato;
	@FXML
	public CheckBox pumkin;
	@FXML
	public CheckBox radish;
	@FXML
	public CheckBox rocket;
	@FXML
	public CheckBox tomato;
	@FXML
	public CheckBox turnip;
	@FXML
	public CheckBox spinach;
	@FXML
	public CheckBox squash;
	@FXML
	public CheckBox apple;
	@FXML
	public CheckBox apricot;
	@FXML
	public CheckBox banana;
	@FXML
	public CheckBox blackberry;
	@FXML
	public CheckBox blueberry;
	@FXML
	public CheckBox cherry;
	@FXML
	public CheckBox coconut;
	@FXML
	public CheckBox fig;
	@FXML
	public CheckBox grape;
	@FXML
	public CheckBox kiwi;
	@FXML
	public CheckBox lemon;
	@FXML
	public CheckBox lime;
	@FXML
	public CheckBox mango;
	@FXML
	public CheckBox melon;
	@FXML
	public CheckBox orange;
	@FXML
	public CheckBox peach;
	@FXML
	public CheckBox pear;
	@FXML
	public CheckBox pineapple;
	@FXML
	public CheckBox plum;
	@FXML
	public CheckBox raspberry;
	@FXML
	public CheckBox strawberry;
	@FXML
	public CheckBox anchovy;
	@FXML
	public CheckBox cod;
	@FXML
	public CheckBox herring;
	@FXML
	public CheckBox mackerel;
	@FXML
	public CheckBox pilchard;
	@FXML
	public CheckBox plaice;
	@FXML
	public CheckBox salmon;
	@FXML
	public CheckBox sardine;
	@FXML
	public CheckBox sole;
	@FXML
	public CheckBox trout;
	@FXML
	public CheckBox tuna;
	@FXML
	public CheckBox bacon;
	@FXML
	public CheckBox beef;
	@FXML
	public CheckBox chicken;
	@FXML
	public CheckBox duck;
	@FXML
	public CheckBox ham;
	@FXML
	public CheckBox lamb;
	@FXML
	public CheckBox liver;
	@FXML
	public CheckBox mince;
	@FXML
	public CheckBox salami;
	@FXML
	public CheckBox sausage;
	@FXML
	public CheckBox turkey;
	@FXML
	public CheckBox veal;
	
	@FXML
	public Button searchBtn;
	
	ArrayList<String> choiceList = new ArrayList<String>();
	RecipeManager rm= RecipeManager.getInstance();
	Recipe rc=rm.getRecipe();
	
	
	public void start() throws Exception {
		Stage ingStage = new Stage();
		FXMLLoader loader = new FXMLLoader (IngredientPage.class.getResource("chooseIngredients.fxml"));
		AnchorPane root = loader.load();
		ingStage.getIcons().add(new Image("img/icon.png"));
        ingStage.setTitle("WhatEat?!" );
        ingStage.setResizable(false);
        Scene scene = new Scene(root, 800, 600);
        ingStage.setScene(scene);
        ingStage.show();
	}
	
	
	
	public void selectButter() {
		if (butter.isSelected()) {
	    	choiceList.add(butter.getText());
	     }else {
	    	 choiceList.remove(butter.getText());
	     }
	}
	
	public void selectCheese() {
		if (cheese.isSelected()) {
        	choiceList.add(cheese.getText());
        }else {
	    	 choiceList.remove(cheese.getText());
	     }
	}
	
	public void selectChocolate() {
		if (chocolate.isSelected()) {
        	choiceList.add(chocolate.getText());
        }else {
	    	 choiceList.remove(chocolate.getText());
	     }
	}
	
	public void selectEggs() {
		if (eggs.isSelected()) {
        	choiceList.add(eggs.getText());
        }
		else {
	    	 choiceList.remove(eggs.getText());
	     }
	}
	
	public void selectFlour() {
		if (flour.isSelected()) {
        	choiceList.add(flour.getText());
        }else {
	    	 choiceList.remove(flour.getText());
	     }
	}
	
	public void selectHoney() {
		if (honey.isSelected()) {
        	choiceList.add(honey.getText());
        }else {
	    	 choiceList.remove(honey.getText());
	     }
	}
	
	public void selectJam() {
		if (jam.isSelected()) {
        	choiceList.add(jam.getText());
        }else {
	    	 choiceList.remove(jam.getText());
	     }
	}
	
	public void selectMilk() {
		if (milk.isSelected()) {
        	choiceList.add(milk.getText());
        }else {
	    	 choiceList.remove(milk.getText());
	     }
	}
	
	public void selectOil() {
		if (oil.isSelected()) {
        	choiceList.add(oil.getText());
        }else {
	    	 choiceList.remove(oil.getText());
	     }
	}
	
	public void selectPasta() {
		if (pasta.isSelected()) {
        	choiceList.add(pasta.getText());
        }else {
	    	 choiceList.remove(pasta.getText());
	     }
	}
	
	public void selectRice() {
		if (rice.isSelected()) {
        	choiceList.add(rice.getText());
        }else {
	    	 choiceList.remove(rice.getText());
	     }
	}
	
	public void selectSalt() {
		if (salt.isSelected()) {
        	choiceList.add(salt.getText());
        }else {
	    	 choiceList.remove(salt.getText());
	     }
	}
	
	public void selectSugar() {
		if (sugar.isSelected()) {
        	choiceList.add(sugar.getText());
        }else {
	    	 choiceList.remove(sugar.getText());
	     }
	}
	
	public void selectWater() {
		if (water.isSelected()) {
        	choiceList.add(water.getText());
        }else {
	    	 choiceList.remove(water.getText());
	     }
	}
	
	public void selectYeast() {
		if (yeast.isSelected()) {
        	choiceList.add(yeast.getText());
        }else {
	    	 choiceList.remove(yeast.getText());
	     }
	}
	
	public void selectYoghurt() {
		if (yoghurt.isSelected()) {
        	choiceList.add(yoghurt.getText());
        }else {
	    	 choiceList.remove(yoghurt.getText());
	     }
	}
	
	public void selectKetchup() {
		if (ketchup.isSelected()) {
        	choiceList.add(ketchup.getText());
        }else {
	    	 choiceList.remove(ketchup.getText());
	     }
	}
	
	public void selectMayonnaise() {
		if (mayonnaise.isSelected()) {
        	choiceList.add(mayonnaise.getText());
        }else {
	    	 choiceList.remove(mayonnaise.getText());
	     }
	}
	
	public void selectMustard() {
		if (mustard.isSelected()) {
        	choiceList.add(mustard.getText());
        }else {
	    	 choiceList.remove(mustard.getText());
	     }
	}
	
	public void selectVinegar() {
		if (vinegar.isSelected()) {
        	choiceList.add(vinegar.getText());
        }else {
	    	 choiceList.remove(vinegar.getText());
	     }
	}
	
	public void selectBasil() {
		if (basil.isSelected()) {
        	choiceList.add(basil.getText());
        }else {
	    	 choiceList.remove(basil.getText());
	     }
	}
	
	public void selectChives() {
		if (chives.isSelected()) {
        	choiceList.add(chives.getText());
        }else {
	    	 choiceList.remove(chives.getText());
	     }
	}
	
	public void selectCoriander() {
		if (coriander.isSelected()) {
        	choiceList.add(coriander.getText());
        }else {
	    	 choiceList.remove(coriander.getText());
	     }
	}
	
	public void selectDill() {
		if (dill.isSelected()) {
        	choiceList.add(dill.getText());
        }else {
	    	 choiceList.remove(dill.getText());
	     }
	}
	
	public void selectParsley() {
		if (parsley.isSelected()) {
        	choiceList.add(parsley.getText());
        }else {
	    	 choiceList.remove(parsley.getText());
	     }
	}
	
	public void selectRosemary() {
		if (rosemary.isSelected()) {
        	choiceList.add(rosemary.getText());
        }else {
	    	 choiceList.remove(rosemary.getText());
	     }
	}
	
	public void selectSage() {
		if (sage.isSelected()) {
        	choiceList.add(sage.getText());
        }else {
	    	 choiceList.remove(sage.getText());
	     }
	}
	
	public void selectThyme() {
		if (thyme.isSelected()) {
        	choiceList.add(thyme.getText());
        }else {
	    	 choiceList.remove(thyme.getText());
	     }
	}
	
	public void selectCinnamon() {
		if (cinnamon.isSelected()) {
        	choiceList.add(cinnamon.getText());
        }else {
	    	 choiceList.remove(cinnamon.getText());
	     }
	}
	
	public void selectCumin() {
		if (cumin.isSelected()) {
        	choiceList.add(cumin.getText());
        }else {
	    	 choiceList.remove(cumin.getText());
	     }
	}
	
	public void selectCurry() {
		if (curry.isSelected()) {
        	choiceList.add(curry.getText());
        }else {
	    	 choiceList.remove(curry.getText());
	     }
	}
	
	public void selectNutmeg() {
		if (nutmeg.isSelected()) {
        	choiceList.add(nutmeg.getText());
        }else {
	    	 choiceList.remove(nutmeg.getText());
	     }
	}
	
	public void selectPaprika() {
		if (paprika.isSelected()) {
        	choiceList.add(paprika.getText());
        }else {
	    	 choiceList.remove(paprika.getText());
	     }
	}
	
	public void selectSaffron() {
		if (saffron.isSelected()) {
        	choiceList.add(saffron.getText());
        }else {
	    	 choiceList.remove(saffron.getText());
	     }
	}
	
	public void selectOlives() {
		if (olives.isSelected()) {
        	choiceList.add(olives.getText());
        }else {
	    	 choiceList.remove(olives.getText());
	     }
	}
	
	public void selectWalnuts() {
		if (walnuts.isSelected()) {
        	choiceList.add(walnuts.getText());
        }else {
	    	 choiceList.remove(walnuts.getText());
	     }
	}
	
	public void selectPeanuts() {
		if (peanuts.isSelected()) {
        	choiceList.add(peanuts.getText());
        }else {
	    	 choiceList.remove(peanuts.getText());
	     }
	}
	
	public void selectNuts() {
		if (nuts.isSelected()) {
        	choiceList.add(nuts.getText());
        }else {
	    	 choiceList.remove(nuts.getText());
	     }
	}
	
	public void selectArtichoke() {
		if (artichoke.isSelected()) {
        	choiceList.add(artichoke.getText());
        }else {
	    	 choiceList.remove(artichoke.getText());
	     }
	}
	
	public void selectAsparagus() {
		if (asparagus.isSelected()) {
        	choiceList.add(asparagus.getText());
        }else {
	    	 choiceList.remove(asparagus.getText());
	     }
	}
	
	public void selectAubergine() {
		if (aubergine.isSelected()) {
        	choiceList.add(aubergine.getText());
        }else {
	    	 choiceList.remove(aubergine.getText());
	     }
	}
	
	public void selectAvocado() {
		if (avocado.isSelected()) {
        	choiceList.add(avocado.getText());
        }else {
	    	 choiceList.remove(avocado.getText());
	     }
	}
	
	public void selectBeansprouts() {
		if (beansprouts.isSelected()) {
        	choiceList.add(beansprouts.getText());
        }else {
	    	 choiceList.remove(beansprouts.getText());
	     }
	}
	
	public void selectBeetroot() {
		if (beetroot.isSelected()) {
        	choiceList.add(beetroot.getText());
        }else {
	    	 choiceList.remove(beetroot.getText());
	     }
	}
	
	public void selectBroadbeans() {
		if (broadbeans.isSelected()) {
        	choiceList.add(broadbeans.getText());
        }else {
	    	 choiceList.remove(broadbeans.getText());
	     }
	}
	
	public void selectBroccoli() {
		if (broccoli.isSelected()) {
        	choiceList.add(broccoli.getText());
        }else {
	    	 choiceList.remove(broccoli.getText());
	     }
	}
	
	public void selectCabbage() {
		if (cabbage.isSelected()) {
        	choiceList.add(cabbage.getText());
        }else {
	    	 choiceList.remove(cabbage.getText());
	     }
	}
	
	public void selectCarrot() {
		if (carrot.isSelected()) {
        	choiceList.add(carrot.getText());
        }else {
	    	 choiceList.remove(carrot.getText());
	     }
	}
	
	public void selectCauliflower() {
		if (cauliflower.isSelected()) {
        	choiceList.add(cauliflower.getText());
        }else {
	    	 choiceList.remove(cauliflower.getText());
	     }
	}
	
	public void selectCelery() {
		if (celery.isSelected()) {
        	choiceList.add(celery.getText());
        }else {
	    	 choiceList.remove(celery.getText());
	     }
	}
	
	public void selectChillipepper() {
		if (chillipepper.isSelected()) {
        	choiceList.add(chillipepper.getText());
        }else {
	    	 choiceList.remove(chillipepper.getText());
	     }
	}
	
	public void selectCourgette() {
		if (courgette.isSelected()) {
        	choiceList.add(courgette.getText());
        }else {
	    	 choiceList.remove(courgette.getText());
	     }
	}
	
	public void selectCucumber() {
		if (cucumber.isSelected()) {
        	choiceList.add(cucumber.getText());
        }else {
	    	 choiceList.remove(cucumber.getText());
	     }
	}
	
	public void selectFrenchbeans() {
		if (frenchbeans.isSelected()) {
        	choiceList.add(frenchbeans.getText());
        }else {
	    	 choiceList.remove(frenchbeans.getText());
	     }
	}
	
	public void selectGarlic() {
		if (garlic.isSelected()) {
        	choiceList.add(garlic.getText());
        }else {
	    	 choiceList.remove(garlic.getText());
	     }
	}
	
	public void selectGinger() {
		if (ginger.isSelected()) {
        	choiceList.add(ginger.getText());
        }else {
	    	 choiceList.remove(ginger.getText());
	     }
	}
	
	public void selectLeek() {
		if (leek.isSelected()) {
        	choiceList.add(leek.getText());
        }else {
	    	 choiceList.remove(leek.getText());
	     }
	}
	
	public void selectLettuce() {
		if (lettuce.isSelected()) {
        	choiceList.add(lettuce.getText());
        }else {
	    	 choiceList.remove(lettuce.getText());
	     }
	}
	
	public void selectMushroom() {
		if (mushroom.isSelected()) {
        	choiceList.add(mushroom.getText());
        }else {
	    	 choiceList.remove(mushroom.getText());
	     }
	}
	
	public void selectOnion() {
		if (onion.isSelected()) {
        	choiceList.add(onion.getText());
        }else {
	    	 choiceList.remove(onion.getText());
	     }
	}
	
	public void selectPeas() {
		if (peas.isSelected()) {
        	choiceList.add(peas.getText());
        }else {
	    	 choiceList.remove(peas.getText());
	     }
	}
	
	public void selectPepper() {
		if (pepper.isSelected()) {
        	choiceList.add(pepper.getText());
        }else {
	    	 choiceList.remove(pepper.getText());
	     }
	}
	
	public void selectPotato() {
		if (potato.isSelected()) {
        	choiceList.add(potato.getText());
        }else {
	    	 choiceList.remove(potato.getText());
	     }
	}
	
	public void selectPumkin() {
		if (pumkin.isSelected()) {
        	choiceList.add(pumkin.getText());
        }else {
	    	 choiceList.remove(pumkin.getText());
	     }
	}
	
	public void selectRadish() {
		if (radish.isSelected()) {
        	choiceList.add(radish.getText());
        }else {
	    	 choiceList.remove(radish.getText());
	     }
	}
	
	public void selectRocket() {
		if (rocket.isSelected()) {
        	choiceList.add(rocket.getText());
        }else {
	    	 choiceList.remove(rocket.getText());
	     }
	}
	
	public void selectTomato() {
		if (tomato.isSelected()) {
        	choiceList.add(tomato.getText());
        }else {
	    	 choiceList.remove(tomato.getText());
	     }
	}
	
	public void selectTurnip() {
		if (turnip.isSelected()) {
        	choiceList.add(turnip.getText());
        }else {
	    	 choiceList.remove(turnip.getText());
	     }
	}
	
	public void selectSpinach() {
		if (spinach.isSelected()) {
        	choiceList.add(spinach.getText());
        }else {
	    	 choiceList.remove(spinach.getText());
	     }
	}
	
	public void selectSquash() {
		if (squash.isSelected()) {
        	choiceList.add(squash.getText());
        }else {
	    	 choiceList.remove(squash.getText());
	     }
	}
	
	public void selectApple() {
		if (apple.isSelected()) {
        	choiceList.add(apple.getText());
        }else {
	    	 choiceList.remove(apple.getText());
	     }
	}
	
	public void selectApricot() {
		if (apricot.isSelected()) {
        	choiceList.add(apricot.getText());
        }else {
	    	 choiceList.remove(apricot.getText());
	     }
	}
	
	public void selectBanana() {
		if (banana.isSelected()) {
        	choiceList.add(banana.getText());
        }else {
	    	 choiceList.remove(banana.getText());
	     }
	}
	
	public void selectBlackberry() {
		if (blackberry.isSelected()) {
        	choiceList.add(blackberry.getText());
        }else {
	    	 choiceList.remove(blackberry.getText());
	     }
	}
	
	public void selectBlueberry() {
		if (blueberry.isSelected()) {
        	choiceList.add(blueberry.getText());
        }else {
	    	 choiceList.remove(blueberry.getText());
	     }
	}
	
	public void selectCherry() {
		if (cherry.isSelected()) {
        	choiceList.add(cherry.getText());
        }else {
	    	 choiceList.remove(cherry.getText());
	     }
	}
	
	public void selectCoconut() {
		if (coconut.isSelected()) {
        	choiceList.add(coconut.getText());
        }else {
	    	 choiceList.remove(coconut.getText());
	     }
	}
	
	public void selectFig() {
		if (fig.isSelected()) {
        	choiceList.add(fig.getText());
        }else {
	    	 choiceList.remove(fig.getText());
	     }
	}
	
	public void selectGrape() {
		if (grape.isSelected()) {
        	choiceList.add(grape.getText());
        }else {
	    	 choiceList.remove(grape.getText());
	     }
	}
	
	public void selectKiwi() {
		if (kiwi.isSelected()) {
        	choiceList.add(kiwi.getText());
        }else {
	    	 choiceList.remove(kiwi.getText());
	     }
	}
	
	public void selectLemon() {
		if (lemon.isSelected()) {
        	choiceList.add(lemon.getText());
        }else {
	    	 choiceList.remove(lemon.getText());
	     }
	}
	
	public void selectLime() {
		if (lime.isSelected()) {
        	choiceList.add(lime.getText());
        }else {
	    	 choiceList.remove(lime.getText());
	     }
	}
	
	public void selectMango() {
		if (mango.isSelected()) {
        	choiceList.add(mango.getText());
        }else {
	    	 choiceList.remove(mango.getText());
	     }
	}
	
	public void selectMelon() {
		if (melon.isSelected()) {
        	choiceList.add(melon.getText());
        }else {
	    	 choiceList.remove(melon.getText());
	     }
	}
	
	public void selectOrange() {
		if (orange.isSelected()) {
        	choiceList.add(orange.getText());
        }else {
	    	 choiceList.remove(orange.getText());
	     }
	}
	
	public void selectPeach() {
		if (peach.isSelected()) {
        	choiceList.add(peach.getText());
        }else {
	    	 choiceList.remove(peach.getText());
	     }
	}
	
	public void selectPear() {
		if (pear.isSelected()) {
        	choiceList.add(pear.getText());
        }else {
	    	 choiceList.remove(pear.getText());
	     }
	}
	
	public void selectPineapple() {
		if (pineapple.isSelected()) {
        	choiceList.add(pineapple.getText());
        }else {
	    	 choiceList.remove(pineapple.getText());
	     }
	}
	
	public void selectPlum() {
		if (plum.isSelected()) {
        	choiceList.add(plum.getText());
        }else {
	    	 choiceList.remove(plum.getText());
	     }
	}
	
	public void selectRaspberry() {
		if (raspberry.isSelected()) {
        	choiceList.add(raspberry.getText());
        }else {
	    	 choiceList.remove(raspberry.getText());
	     }
	}
	
	public void selectStrawberry() {
		if (strawberry.isSelected()) {
        	choiceList.add(strawberry.getText());
        }else {
	    	 choiceList.remove(strawberry.getText());
	     }
	}
	
	public void selectAnchovy() {
		if (anchovy.isSelected()) {
        	choiceList.add(anchovy.getText());
        }else {
	    	 choiceList.remove(anchovy.getText());
	     }
	}
	
	public void selectCod() {
		if (cod.isSelected()) {
        	choiceList.add(cod.getText());
        }else {
	    	 choiceList.remove(cod.getText());
	     }
	}
	
	public void selectHerring() {
		if (herring.isSelected()) {
        	choiceList.add(herring.getText());
        }else {
	    	 choiceList.remove(herring.getText());
	     }
	}
	
	public void selectMackerel() {
		if (mackerel.isSelected()) {
        	choiceList.add(mackerel.getText());
        }else {
	    	 choiceList.remove(mackerel.getText());
	     }
	}
	
	public void selectPilchard() {
		if (pilchard.isSelected()) {
        	choiceList.add(pilchard.getText());
        }else {
	    	 choiceList.remove(pilchard.getText());
	     }
	}
	
	public void selectPlaice() {
		if (plaice.isSelected()) {
        	choiceList.add(plaice.getText());
        }else {
	    	 choiceList.remove(plaice.getText());
	     }
	}
	
	public void selectSalmon() {
		if (salmon.isSelected()) {
        	choiceList.add(salmon.getText());
        }else {
	    	 choiceList.remove(salmon.getText());
	     }
	}
	
	public void selectSardine() {
		if (sardine.isSelected()) {
        	choiceList.add(sardine.getText());
        }else {
	    	 choiceList.remove(sardine.getText());
	     }
	}
	
	public void selectSole() {
		if (sole.isSelected()) {
        	choiceList.add(sole.getText());
        }else {
	    	 choiceList.remove(sole.getText());
	     }
	}
	
	public void selectTrout() {
		if (trout.isSelected()) {
        	choiceList.add(trout.getText());
        }else {
	    	 choiceList.remove(trout.getText());
	     }
	}
	
	public void selectTuna() {
		if (tuna.isSelected()) {
        	choiceList.add(tuna.getText());
        }else {
	    	 choiceList.remove(tuna.getText());
	     }
	}
	
	public void selectBacon() {
		if (bacon.isSelected()) {
        	choiceList.add(bacon.getText());
        }else {
	    	 choiceList.remove(bacon.getText());
	     }
	}
	
	public void selectBeef() {
		if (beef.isSelected()) {
        	choiceList.add(beef.getText());
        }else {
	    	 choiceList.remove(beef.getText());
	     }
	}
	
	public void selectChicken() {
		if (chicken.isSelected()) {
        	choiceList.add(chicken.getText());
        }else {
	    	 choiceList.remove(chicken.getText());
	     }
	}
	
	public void selectDuck() {
		if (duck.isSelected()) {
        	choiceList.add(duck.getText());
        }else {
	    	 choiceList.remove(duck.getText());
	     }
	}
	
	public void selectHam() {
		if (ham.isSelected()) {
        	choiceList.add(ham.getText());
        }else {
	    	 choiceList.remove(ham.getText());
	     }
	}
	
	public void selectLamb() {
		if (lamb.isSelected()) {
        	choiceList.add(lamb.getText());
        }else {
	    	 choiceList.remove(lamb.getText());
	     }
	}
	
	public void selectLiver() {
		if (liver.isSelected()) {
        	choiceList.add(liver.getText());
        }else {
	    	 choiceList.remove(liver.getText());
	     }
	}
	
	public void selectMince() {
		if (mince.isSelected()) {
        	choiceList.add(mince.getText());
        }else {
	    	 choiceList.remove(mince.getText());
	     }
	}
	
	public void selectSalami() {
		if (salami.isSelected()) {
        	choiceList.add(salami.getText());
        }else {
	    	 choiceList.remove(salami.getText());
	     }
	}
	
	public void selectSausage() {
		if (sausage.isSelected()) {
        	choiceList.add(sausage.getText());
        }else {
	    	 choiceList.remove(sausage.getText());
	     }
	}
	
	public void selectTurkey() {
		if (turkey.isSelected()) {
        	choiceList.add(turkey.getText());
        }else {
	    	 choiceList.remove(turkey.getText());
	     }
	}
	
	public void selectVeal() {
		if (veal.isSelected()) {
        	choiceList.add(veal.getText());
        }else {
	    	 choiceList.remove(veal.getText());
	     }
	}
	
	
	public void selectIngredients(ActionEvent e) throws Exception{
		
		System.out.println(choiceList);
		rc.setIngredient(choiceList);
		rm.setRecipe(rc);
		((Node)(e.getSource())).getScene().getWindow().hide();
	    GraphicController graphicController = new GraphicController();
	    graphicController.foundPage();
	}
	
	public void back(ActionEvent e) throws Exception {
		((Node)(e.getSource())).getScene().getWindow().hide();
    	GraphicController graphicController = new GraphicController();
        graphicController.difficultPage();
	}
}
