# karate

Karate example project

## Installation

Windows:
```bash
mvn archetype:generate `
-DarchetypeGroupId=com.intuit.karate `
-DarchetypeArtifactId=karate-archetype `
-DarchetypeVersion=X.X.X `
-DgroupId=com.nallani `
-DartifactId=karate-project
```
Mac:
```bash
mvn archetype:generate \
-DarchetypeGroupId=io.karatelabs \
-DarchetypeArtifactId=karate-archetype \
-DarchetypeVersion=1.5.0 \
-DgroupId=com.nallani \
-DartifactId=karate-project
```

## Usage

```python
mvn clean test
```

## License

[MIT](https://choosealicense.com/licenses/mit/)