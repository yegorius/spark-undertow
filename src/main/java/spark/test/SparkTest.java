package spark.test;

import spark.Route;
import spark.Spark;

public class SparkTest {
    
    public static void main(String[] args) {
        Spark.get("/sport/:section", new Route() {
            @Override
            public Object handle() {
                return "these are the sport pages, section: " + params(":section") + ", " + request.ip();
            }
        });
        
        Spark.get("/news/:section", new Route() {
            @Override
            public Object handle() {
                return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><news>" + params("section") + "</news>";
            }
        });
        
        Spark.get("/redirect", new Route() {
            @Override
            public Object handle() {
                redirect("/news/world");
                return null;
            }
        });
        
        Spark.get("/", new Route() {
            @Override
            public Object handle() {
                return "root";
            }
        });
        
        Spark.post("/", new Route() {
            @Override
            public Object handle() {
                return "echo: " + request.body();
            }
        });
    }
}