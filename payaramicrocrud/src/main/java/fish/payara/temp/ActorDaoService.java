package fish.payara.temp;

import org.eclipse.microprofile.openapi.annotations.Components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActorDaoService {

    private static List<Actor> actors = new ArrayList<>();
    private static int actorsCount = 3;

    static {
        actors.add(new Actor(1, "Murtaza", "Multan"));
        actors.add(new Actor(2, "Husain", "Jack"));
        actors.add(new Actor(3, "Mustafa", "Multan"));
    }

    public List<Actor> findAll() {
        return actors;
    }

    public Actor save(Actor Actor) {

        if(Actor.getId() == null){
            Actor.setId(++actorsCount);
        }
        actors.add(Actor);
        return Actor;
    }

    public Actor findOne(int id){

        for(Actor Actor: actors) {
            if(Actor.getId() == id)
                return Actor;
        }

        return null;
    }


    public Actor deleteById(int id){
        Iterator<Actor> iterator = actors.iterator();

        while(iterator.hasNext()) {
            Actor tempActor = iterator.next();

            if(tempActor.getId() == id) {
                iterator.remove();
                return tempActor;
            }
        }

        return null;
    }
}
