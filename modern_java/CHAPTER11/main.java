import java.util.Optional;
import java.util.Properties;

public class main {
    public static void main(String[] args) {

        //Person 과 Car 정보를 이용해 가장 저렴한 보험료를 제공하는 보험회사 찾기

    }

    static Insurance findCheapestInsurance(Person person, Car car){
        //다양한 보험회사가 제공하는 서비스 조회
        //모든 결과 데이터 비교
        return cheapestInsurace;
    }

    static Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car){

        if(person.isPresent() && car.isPresent()){
            return Optional.of(findCheapestInsurance(person.get(), car.get()));
        }else{
            return Optional.empty();
        }
    }

    //퀴즈 11-1
    static Optional<Insurance> nullSafeFindCheapestInsurance_v2(Optional<Person> person, Optional<Car> car){

        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p,c)));
    }

    //퀴즈 11-2
    static String getCarInsuranceName(Optional<Person> person, int minAge){
        return person.filter(p -> p.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("unknown");
    }
}
