package seminars.third.tdd;

public class MoodAnalyser {
    // SAD Message -> грустное
    // HAPPY Message -> веселое
        public String analyseMood(String message){
            if (message.contains(("грустное"))){
                return "SAD";
            } else  {
                return "HAPPY";
            }

        }
    }

