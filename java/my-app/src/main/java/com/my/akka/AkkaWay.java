package com.my.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class AkkaWay {

    public static void RunAkkaWay(String[] args) {
        new AkkaWay().run();
    }

    private void run() {
        ActorSystem system = ActorSystem.create("CalcSystem");
        ActorRef master = system.actorOf(Master.createMaster(), "master");
        master.tell(new Calculate(), ActorRef.noSender());
    }
}
