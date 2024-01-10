package hw6.c5.countryarraymanager;

public class CountryArrayManager {
    private Country[] countries;
    private int length;
    private int increment;

    public CountryArrayManager() {
        this.increment = 10;
        countries = new Country[this.increment];
        this.length = 0;
    }

    public CountryArrayManager(int maxLength) {
        this.increment = 10;
        countries = new Country[maxLength];
        this.length = 0;
    }

    public int getLength() {
        return this.length;
    }

    public Country[] getCountries() {
        return this.countries;
    }

    private void correct() {
        int nullFirstIndex = 0;
        for (int i = 0; i < this.countries.length; i++) {
            if (this.countries[i] == null) {
                nullFirstIndex = i;
                break;
            }
        }

        if (nullFirstIndex > 0) {
            this.length = nullFirstIndex;
            for (int i = nullFirstIndex; i < this.countries.length; i++) {
                this.countries[i] = null;
            }
        }
    }

    private void allocateMore() {
        Country[] newArray = new Country[this.countries.length + this.increment];
        System.arraycopy(this.countries, 0, newArray, 0, this.countries.length);
        this.countries = newArray;
    }

    public void append(Country country) {
        if (this.length >= this.countries.length) {
            allocateMore();
        }

        this.countries[this.length] = country;
        this.length++;
    }

    public boolean add(Country country, int index) {
        if ((index < 0) || (index > this.countries.length)) {
            return false;
        }

        if (this.length >= this.countries.length) {
            allocateMore();
        }

        for (int i = this.length; i > index; i--) {
            this.countries[i] = this.countries[i-1];
        }

        this.countries[index] = country;
        this.length++;
        return true;
    }

    public boolean remove(int index) {
        if ((index < 0) || (index >= countries.length)) {
            return false;
        }

        for (int i = index; i < length - 1; i++) {
            this.countries[i] = this.countries[i + 1];
        }

        this.countries[this.length - 1] = null;
        this.length--;
        return true;
    }

    public Country countryAt(int index) {
        if ((index < 0) || (index >= this.length)) {
            return null;
        }

        return this.countries[index];
    }

    /**
     * Sort the countries in order of increasing population 
     *  using selection sort algorithm.
     * @return array of increasing population countries.
     */
    public Country[] sortByIncreasingPopulation() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);
        
        /* TODO */
        Country temp;
        for (int i = 0; i < newArray.length - 1; i++){
            int min_idx = i;
            for (int j = i + 1; j < newArray.length; j++){
                if (newArray[j].getPopulation() < newArray[min_idx].getPopulation()){
                    min_idx = j;
                }
            }
            temp = newArray[min_idx];
            newArray[min_idx] = newArray[i];
            newArray[i] = temp;
        }
        return newArray;
    }

    /**
     * Sort the countries in order of decreasing population 
     * using selection sort algorithm.
     * @return array of decreasing population countries.
     */
    public Country[] sortByDecreasingPopulation() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);
        
        /* TODO */
        Country temp;
        for (int i = 0; i < newArray.length - 1; i++){
            int min_idx = i;
            for (int j = i + 1; j < newArray.length; j++){
                if (newArray[j].getPopulation() > newArray[min_idx].getPopulation()){
                    min_idx = j;
                }
            }
            temp = newArray[min_idx];
            newArray[min_idx] = newArray[i];
            newArray[i] = temp;
        }
        return newArray;
    }

    /**
     * Sort the countries in order of increasing area
     * using bubble sort algorithm.
     * @return array of increasing area countries.
     */
    public Country[] sortByIncreasingArea() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);
        
        /* TODO */
        for (int i = 0; i < newArray.length - 1; i++){
            for (int j = i + 1; j < newArray.length; j++){
                if (newArray[j].getArea() < newArray[i].getArea()){
                    Country temp;
                    temp = newArray[i];
                    newArray[i] = newArray[j];
                    newArray[j] = temp;
                }
            }
        }
        return newArray;
    }

    /**
     * Sort the countries in order of decreasing area 
     * using bubble sort algorithm.
     * @return array of increasing area countries.
     */
    public Country[] sortByDecreasingArea() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);
        
        /* TODO */
        for (int i = 0; i < newArray.length - 1; i++){
            for (int j = i + 1; j < newArray.length; j++){
                if (newArray[j].getArea() > newArray[i].getArea()){
                    Country temp;
                    temp = newArray[i];
                    newArray[i] = newArray[j];
                    newArray[j] = temp;
                }
            }
        }
        return newArray;
    }

    /**
     * Sort the countries in order of increasing GDP 
     * using insertion sort algorithm.
     * @return array of increasing GDP countries.
     */
    public Country[] sortByIncreasingGdp() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);
        
        /* TODO */
        int n = newArray.length;
        for (int i = 1; i < n; ++i) {
            Country key = newArray[i];
            int j = i - 1;

            // Di chuyển các phần tử của arr [0 ... i - 1], lớn hơn key
            // đến một vị trí trước vị trí hiện tại của chúng
            while (j >= 0 && newArray[j].getGdp() > key.getGdp()) {
                newArray[j + 1] = newArray[j];
                j = j - 1;
            }
            newArray[j + 1] = key;
        }
        return newArray;
    }

    /**
     * Sort the countries in order of increasing GDP 
     * using insertion sort algorithm.
     * @return array of increasing insertion countries.
     */
    public Country[] sortByDecreasingGdp() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);
        
        /* TODO */
        int n = newArray.length;
        for (int i = 1; i < n; ++i) {
            Country key = newArray[i];
            int j = i - 1;

            // Di chuyển các phần tử của arr [0 ... i - 1], lớn hơn key
            // đến một vị trí trước vị trí hiện tại của chúng
            while (j >= 0 && newArray[j].getGdp() < key.getGdp()) {
                newArray[j + 1] = newArray[j];
                j = j - 1;
            }
            newArray[j + 1] = key;
        }
        return newArray;
    }

    public AfricaCountry[] filterAfricaCountry() {
        /* TODO */
        AfricaCountry[] newArray = new AfricaCountry[countries.length];
        int idx = 0;
        for (int i = 0; i < countries.length; i++){
            if (countries[i] instanceof AfricaCountry){
                newArray[idx] = (AfricaCountry) countries[i];
                idx++;
            }
        }
        return newArray;
    }

    public AsiaCountry[] filterAsiaCountry() {
        /* TODO */
        AsiaCountry[] newArray = new AsiaCountry[countries.length];
        int idx = 0;
        for (int i = 0; i < countries.length; i++){
            if (countries[i] instanceof AsiaCountry){
                newArray[idx] = (AsiaCountry) countries[i];
                idx++;
            }
        }
        return newArray;
    }

    public EuropeCountry[] filterEuropeCountry() {
        /* TODO */
        EuropeCountry[] newArray = new EuropeCountry[countries.length];
        int idx = 0;
        for (int i = 0; i < countries.length; i++){
            if (countries[i] instanceof EuropeCountry){
                newArray[idx] = (EuropeCountry) countries[i];
                idx++;
            }
        }
        return newArray;
    }

    public NorthAmericaCountry[] filterNorthAmericaCountry() {
        /* TODO */
        NorthAmericaCountry[] newArray = new NorthAmericaCountry[countries.length];
        int idx = 0;
        for (int i = 0; i < countries.length; i++){
            if (countries[i] instanceof NorthAmericaCountry){
                newArray[idx] = (NorthAmericaCountry) countries[i];
                idx++;
            }
        }
        return newArray;
    }

    public OceaniaCountry[] filterOceaniaCountry() {
        /* TODO */
        OceaniaCountry[] newArray = new OceaniaCountry[countries.length];
        int idx = 0;
        for (int i = 0; i < countries.length; i++){
            if (countries[i] instanceof OceaniaCountry){
                newArray[idx] = (OceaniaCountry) countries[i];
                idx++;
            }
        }
        return newArray;
    }

    public SouthAmericaCountry[] filterSouthAmericaCountry() {
        /* TODO */
        SouthAmericaCountry[] newArray = new SouthAmericaCountry[countries.length];
        int idx = 0;
        for (int i = 0; i < countries.length; i++){
            if (countries[i] instanceof SouthAmericaCountry){
                newArray[idx] = (SouthAmericaCountry) countries[i];
                idx++;
            }
        }
        return newArray;
    }

    public Country[] filterMostPopulousCountries(int howMany) {
        /* TODO */
        Country[] result = new Country[howMany];
        Country[] newArray = sortByDecreasingPopulation();
        for (int i = 0; i < howMany; i++){
            result[i] = newArray[i];
        }
        return result;
    }

    public Country[] filterLeastPopulousCountries(int howMany) {
        /* TODO */
        Country[] result = new Country[howMany];
        Country[] newArray = sortByIncreasingArea();
        for (int i = 0; i < howMany; i++){
            result[i] = newArray[i];
        }
        return result;
    }

    public Country[] filterLargestAreaCountries(int howMany) {
        /* TODO */
        Country[] result = new Country[howMany];
        Country[] newArray = sortByDecreasingArea();
        for (int i = 0; i < howMany; i++){
            result[i] = newArray[i];
        }
        return result;
    }

    public Country[] filterSmallestAreaCountries(int howMany) {
        /* TODO */
        Country[] result = new Country[howMany];
        Country[] newArray = sortByIncreasingArea();
        for (int i = 0; i < howMany; i++){
            result[i] = newArray[i];
        }
        return result;
    }

    public Country[] filterHighestGdpCountries(int howMany) {
        /* TODO */
        Country[] result = new Country[howMany];
        Country[] newArray = sortByDecreasingGdp();
        for (int i = 0; i < howMany; i++){
            result[i] = newArray[i];
        }
        return result;
    }

    public Country[] filterLowestGdpCountries(int howMany) {
        /* TODO */
        Country[] result = new Country[howMany];
        Country[] newArray = sortByIncreasingGdp();
        for (int i = 0; i < howMany; i++){
            result[i] = newArray[i];
        }
        return result;
    }

    public static String codeOfCountriesToString(Country[] countries) {
        StringBuilder codeOfCountries = new StringBuilder();
        codeOfCountries.append("[");
        for (int i = 0; i < countries.length; i++) {
            Country country = countries[i];
            if (country != null) {
                codeOfCountries.append(country.getCode())
                        .append(" ");
            }
        }
        
        return codeOfCountries.toString().trim() + "]";
    }

    public static void print(Country[] countries) {
        StringBuilder countriesString = new StringBuilder();
        countriesString.append("[");
        for (int i = 0; i < countries.length; i++) {
            Country country = countries[i];
            if (country != null) {
                countriesString.append(country.toString()).append("\n");
            }
        }
        System.out.print(countriesString.toString().trim() + "]");
    }
}
