package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void move() {
        cars.stream()
                .filter(car -> car.canGo(RandomNumberGenerator.makeRandomNumber()))
                .forEach(Car::go);
    }

    public List<String> getWinner() {
        List<String> winner = new ArrayList<>();
        int winnerPosition = getWinnerPosition();

        for (Car car : cars) {
            if (car.isWinner(winnerPosition)) {
                winner.add(car.getName());
            }
        }
        return winner;
    }

    private int getWinnerPosition() {
        int winnerPosition = 0;
        for (Car car : cars) {
            if (winnerPosition < car.getPosition()) {
                winnerPosition = car.getPosition();
            }
        }
        return winnerPosition;
    }

    public List<Car> getCars() {
        return cars;
    }
}
