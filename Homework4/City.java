package Homework4;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class City {
    private Map<Intersection, List<Street>> cityMap = new HashMap<>();

    public City() {
    }

    public City(Map<Intersection, List<Street>> cityMap) {
        this.cityMap = cityMap;
    }

    public City(Intersection[] nodes, List<Street> streetsList) {

    }

    public Map<Intersection, List<Street>> getCityMap() {
        return cityMap;
    }

    public void setCityMap(Map<Intersection, List<Street>> cityMap) {
        this.cityMap = cityMap;
    }

    public void addToCity(Intersection intersection, List<Street> listStreet) {
        this.cityMap.put(intersection, listStreet);
    }

    public void print() {
        for (Intersection intersection : cityMap.keySet()) {
            System.out.println(intersection.getName() + cityMap.get(intersection).toString());

        }
    }

    public void printStreets(int length, List<Street> streetsList, int joinNR) {
        System.out.println("Streets that are longer that " + length + " and join at least " + joinNR + " :");
        Street e;
        streetsList.stream()
                .filter(v -> v.getLength() >= length)
                .filter(v -> cityMap.get(v.getIntersection1()).size() + cityMap.get(v.getIntersection2()).size() >= joinNR + 2)
                .forEach(System.out::println);
    }

    public void nameStreetsIntersections(List<Street> streetsList) {
        for (Intersection i : cityMap.keySet()) {
            Faker faker = new Faker();
            i.setName(faker.hobbit().character());
        }
        for (Street s : streetsList) {
            Faker faker = new Faker();
            s.setName(faker.harryPotter().character() + " Street");
        }

    }
}

