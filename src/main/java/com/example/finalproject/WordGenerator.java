package com.example.finalproject;

public class WordGenerator {

    public WordGenerator(){

    }



    public String level1_stage1(){
       String [] fourLetterword = new String[6];

        fourLetterword[0]="Your";
        fourLetterword[1]="Tour";
        fourLetterword[2]="Gore";
        fourLetterword[3]="Sore";
        fourLetterword[4]="Yolk";
        fourLetterword[5]="Aura";


        int i = (int) (Math.random() * 5) + 1;


        return fourLetterword[i];
    }
    public String level1_stage2(){
        String [] fourLetterword = new String[7];

        fourLetterword[0]="Hole";
        fourLetterword[1]="Four";
        fourLetterword[2]="Foal";
        fourLetterword[3]="Roar";
        fourLetterword[4]="Coal";
        fourLetterword[5]="Dole";
        fourLetterword[6]="Mole";

        int i = (int) (Math.random() * 6) + 1;


        return fourLetterword[i];
    }

    public String level2_stage1(){
        String[] phrases = new String[5];
        phrases[0] = "Life is a beautiful adventure.";
        phrases[1] = "Dream big, work even bigger.";
        phrases[2] = "The stars shine the brightest.";
        phrases[3] = "Happiness is homemade every day.";
        phrases[4] = "Always believe in your magic.";



        int i = (int) (Math.random() * 4) + 1;
        return phrases[i];

    }
    public String level2_stage2(){
        String[] phrases = new String[5];
        phrases[0] = "Chasing sunsets and wild dreams.";
        phrases[1] = "Kindness is the ultimate superpower.";
        phrases[2] = "Laugh louder, love harder, live longer.";
        phrases[3] = "Success starts with a single step.";
        phrases[4] = "Courage is found in small moments.";


        int i = (int) (Math.random() * 4) + 1;
        return phrases[i];

    }

    public String level3_stage1(){
        String [] compoundSentence= new String[5];

        compoundSentence[0]="Hey everyone, How's it Going? Look a bit dull all of you.";
        compoundSentence[1]="Oh come on, Let's lighten up the mood everyone,what,s wrong?";
        compoundSentence[2]="Oh and um, you guys ,you are the real heroes.";
        compoundSentence[3] = "The world is full of opportunities for those who seek.";
        compoundSentence[4] = "Dreams are built with passion, determination, and endless perseverance.";


        int i = (int) (Math.random() * 4) + 1;
        return compoundSentence[i];

    }
    public String level3_stage2(){
        String [] compoundSentence= new String[5];

        compoundSentence[0] = "Every sunrise is a chance to create a new story.";
        compoundSentence[1] = "Courage is found in moments when fear feels the strongest.";
        compoundSentence[2] = "The stars remind us there’s beauty even in the darkness.";
        compoundSentence[3] = "Great things happen when preparation meets the right opportunity.";
        compoundSentence[4] = "Kindness costs nothing but leaves a priceless impact on others.";

        int i = (int) (Math.random() * 4) + 1;
        return compoundSentence[i];

    }
    public String level4_stage1(){
        String [] complexSentence= new String[5];

        complexSentence[0]="Although the email address john.doe2024@example.com seemed legitimate, the IT department flagged it as suspicious due to its recent creation date.";
        complexSentence[1]="Since the activation link was sent to user.alpha123@domain.org, he had to check his spam folder to ensure it wasn’t missed.";
        complexSentence[2]="Even though the registration form accepted her username, Luna_987, the associated email, luna98!test@mailservice.com, failed verification due to a formatting error.";
        complexSentence[3] = "If you forget your login credentials for admin@secureportal.net, you can request a password reset using your backup email.";
        complexSentence[4] = "Whenever the server logs displayed activity from sysadmin123@corp.net, the team investigated it for potential unauthorized access attempts.";


           int i = (int) (Math.random() * 4) + 1;
           return complexSentence[i];



    }

    public String [] levels = {level1_stage1() , level1_stage2() , level2_stage1() , level2_stage2() , level3_stage1() , level3_stage2() , level4_stage1()};

}
