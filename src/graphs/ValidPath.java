package graphs;

import java.util.*;
import java.util.stream.Collectors;

public class ValidPath {

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        double distance(Point p) {
            return Math.sqrt((p.x - x) * (p.x - x) + (p.y - y) * (p.y - y));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        List<Point> getNeighbours() {
            return Arrays.asList(new Point(x - 1, y + 1), new Point(x, y + 1), new Point(x + 1, y + 1)
                    , new Point(x - 1, y), new Point(x, y), new Point(x + 1, y)
                    , new Point(x - 1, y - 1), new Point(x, y - 1), new Point(x + 1, y - 1));
        }
    }

    class Circle {
        int radius;
        Point centre;

        Circle(int radius, Point centre) {
            this.radius = radius;
            this.centre = centre;
        }

        public boolean isWithinCircle(Point point) {

            return centre.distance(point) <= radius;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Circle circle = (Circle) o;
            return radius == circle.radius &&
                    Objects.equals(centre, circle.centre);
        }

        @Override
        public int hashCode() {
            return Objects.hash(radius, centre);
        }
    }

    public String solve(int x, int y, int N, int R, List<Integer> circlesX, List<Integer> circlesY) {

        Queue<Point> queue = new LinkedList<>();
        Set<Circle> circles = new HashSet<>();
        for (int i = 0; i < circlesX.size(); i++) {
            circles.add(new Circle(R, new Point(circlesX.get(i), circlesY.get(i))));
        }
        Point finalPoint = new Point(x, y);

        queue.add(new Point(0, 0));
        Point curr = null;
        Set<Point> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            curr = queue.poll();
            if (!finalPoint.equals(curr)) {
                visited.add(curr);
                queue.addAll(curr.getNeighbours()
                        .stream()
                        .filter(c -> (c.x >= 0 && c.x <= x) && (c.y >= 0 && c.y <= y))
                        .filter(p -> !visited.contains(p) && !queue.contains(p))
                        .filter(p -> circles.stream().noneMatch(cir -> cir.isWithinCircle(p)))
                        .collect(Collectors.toList()));

            }

        }

        if (curr.equals(finalPoint)) {
            return "YES";
        }

        return "NO";

    }


}
