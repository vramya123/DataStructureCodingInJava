package RegularExp;
import java.util.*;
import java.util.regex.*;
import java.io.*;
//Youtube:- https://www.youtube.com/watch?v=zcU5eeX1tYQ
//https://regex101.com/ to check regex

// Difference Between Glob and Regex:
//=======================================
// Glob-style wildcards (*, ?, [ ]) are used in file matching. Example:
//"/bar/*/var would match /bar/goo/var, /bar/xyz/var, but not /bar//var."
//"Regular expressions (.*, +, ?, [], {}) are more powerful and used in pattern matching across strings."
// "/bar/.*/var (regex) matches /bar/goo/var, /bar/abc123/var, but also /bar//var."

class Route{
	 Map<String,List<String>> routeMap;
	 public Route() {
		 routeMap = new HashMap<>();
	 }
	 
	 public void addRoute(String path, String route) {
		 List<String> routes = new ArrayList<>();
		 boolean regexExistsInPath = checkForRegex(path);
		 if(regexExistsInPath) {
			 //Check if hashMap has this path
			 String keyExistsInMap = checkPathKeyForRegex(path);
			 if(!keyExistsInMap.isEmpty()) {
				 routes =  routeMap.get(keyExistsInMap);
				 path = keyExistsInMap;
			 }
			 
		 }else {
			 if(routeMap.containsKey(path)) {
				 routes =  routeMap.get(path);
			 }
		 }
		 routes.add(route);
		 routeMap.put(path, routes);
	 }
	 
	 
	 public List<String> getRoutes(String path){
		 if(routeMap.containsKey(path)) {
			 return routeMap.get(path);
		 }else {
			 return null;
		 }
	 }
	 
	 public boolean  checkForRegex(String path) {
		 
		 Pattern pattern = Pattern.compile(".*[+*?{}].*");
		 Matcher matcher = pattern.matcher(path);
		 if(matcher.find()) {
			 System.out.println(matcher.group());
			 return true;
		 }else
			 return false;
	 }
	 
	 public String  checkPathKeyForRegex(String path) {
	   Set<String> keys = routeMap.keySet();
	   String matchingPath = "";
	   for(String key: keys) {
		   if(Pattern.matches(path, key)) {
			   matchingPath = key;
		   }
	   }
	   return matchingPath;
	 }
	
}
public class RegularExprSample {

	public static void main(String[] args) {
		Route r = new Route();
		r.addRoute("/bar", "foo");
		r.addRoute("/bar/goo/var", "roo");
		r.addRoute("/bar", "loo");
		r.addRoute("/far", "");
		r.addRoute("/bar/.*/var", "hoo");
		List<String> routes = r.getRoutes("/bar");
		System.out.println(routes);
	}
	
}
