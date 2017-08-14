package pl.mmurawski.constrainlayout;

class RecipeItem {
    private String name;
    private Integer pictureAddress;

    RecipeItem(String name, Integer pictureAddress) {
        this.name = name;
        this.pictureAddress = pictureAddress;
    }

    public String getName() {
        return name;
    }

    public Integer getPictureAddress() {
        return pictureAddress;
    }
}
