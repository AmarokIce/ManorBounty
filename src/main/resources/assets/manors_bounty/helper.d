import std.string;
import std.file;
import std.regex;

void main() {
    scanDir("./");
}

void scanDir(string dir) {
    auto entries = dirEntries(dir, SpanMode.shallow);
    foreach(DirEntry f; entries) {
        if (f.isDir) {
            scanDir(f.name);
        } else {
            fileHandler(f.name);
        }
    }
}

void fileHandler(string file) {
    import std.stdio: writeln;

    writeln(file);

    if (indexOf(file, "bottom") != -1) {
        auto str = file.replace("bottom", "button");
        rename(file, str);
        file = str;
    }

    if (!file.endsWith(".json")) {
        return;
    }

    auto dat = readText(file);
    auto text = dat.replace("botton", "button");
    text = text.replace("door_button", "door_bottom");
    write(file, text);
}
