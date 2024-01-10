package lab8.b4;

import java.util.Comparator;

class RatingCompare implements Comparator<Movie> {
    public int compare(Movie left, Movie right){
        double result = left.getRating() - right.getRating();
        if (result < 0){
            return -1;
        } else if(result == 0){
            return 0;
        } else {
            return 1;
        }
    }
}
