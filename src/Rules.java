import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Geir
 * Date: 10/17/13
 * Time: 15:46
 * To change this template use File | Settings | File Templates.
 */
public class Rules {
    public static boolean hasPair(ArrayList<Card> hand){
        for(int i = 0; i < hand.size()-1; i++){
            if(hand.get(i).getValue() == hand.get(i+1).getValue()){
                return true;
            }
        }
        return false;
    }

    public static boolean hasTwoPairs(ArrayList<Card> hand){
        for(int i = 0; i < hand.size()-3; i++){
            if(hand.get(i).getValue() == hand.get(i+1).getValue()){
                for(int k = i + 1; k < hand.size()-1; k++){
                    if(hand.get(k).getValue() == hand.get(k+1).getValue()){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean hasThreeOfAKind(ArrayList<Card> hand){
        for(int i = 0; i < hand.size()-2; i++){
            if((hand.get(i).getValue() == hand.get(i+1).getValue()) &&
                hand.get(i+1).getValue() == hand.get(i+2).getValue()){
                return true;
            }
        }
        return false;
    }

    public static boolean hasStraight(ArrayList<Card> hand){
        int temp = hand.get(0).getValue();
        for(int i = 1; i < hand.size(); i++){
            if ((temp + 1) == hand.get(i).getValue()){
                if(i == hand.size()-1){
                    return true;
                }
                else{
                    temp = hand.get(i).getValue();
                    continue;
                }
            }
            else{
                break;
            }
        }
        return false;
    }

    public static boolean hasFlush(ArrayList<Card> hand){
        Suits tempSuit = hand.get(0).getSuit();
        for(Card card: hand){
            if(tempSuit != card.getSuit()){
                return false;
            }
        }
        return true;
    }

    public static boolean hasFullHouse(ArrayList<Card> hand){
        if(hasPair(hand) && hasThreeOfAKind(hand)){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean hasFourOfAKind(ArrayList<Card> hand){
        for(int i = 0; i < hand.size()-3; i++){
            if(hand.get(i).getValue() == hand.get(i+1).getValue() &&
                    hand.get(i+1).getValue() == hand.get(i+2).getValue() &&
                    hand.get(i+2).getValue() == hand.get(i+3).getValue()){
                return true;
            }
        }
        return false;
    }

    public static boolean hasStraightFlush(ArrayList<Card> hand){
        return (hasFlush(hand) && hasStraight(hand));
    }

    public static boolean hasRoyalStraightFlush(ArrayList<Card> hand){
        if(hasFlush(hand)){
            for(int i = 0; i < hand.size(); i++){
                if(hand.get(i).getValue() != i+10){
                    return false;
                }
            }
            return true;
        }
        else{
            return false;
        }
    }
}
