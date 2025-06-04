import std.file;
import std.stdio;
import std.string;

void main() {
    auto entry = dirEntries("./recipes", SpanMode.shallow);
    foreach(string f; entry) {
        if (f.endsWith("oven_recipe.json")) {
            copy(f, "./oven_recipe/" ~ f.replace("./recipes", ""));
        }
    }
}