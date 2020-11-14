package annotations.handle;

@PrepareMyTest(value = {AnnotationHandle.class, SomeTest.class}, fullyQualifiedNames = {"annotations.handle.Fox"})
public class SomeTest {
}
