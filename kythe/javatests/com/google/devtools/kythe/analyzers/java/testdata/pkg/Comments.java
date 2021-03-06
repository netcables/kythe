package pkg;

//- @+6"java.lang.Integer" ref/doc IntegerClass
//- @+5String ref/doc StringClass
//- @+5Inner ref/doc InnerClass
//- @+6Comments defines/binding CommentsClass

/**
 * This is a Javadoc comment with links to {@link String}, {@link java.lang.Integer}, and
 * {@link Inner}.
 */
public class Comments
    implements Comparable<Comments> {

  //- DocNode.node/kind doc
  //- DocNode.subkind "javadoc"
  //- DocNode documents CommentsClass
  //- DocNode param.0 StringClass
  //- DocNode param.1 IntegerClass
  //- DocNode param.2 InnerClass
  //- DocNode.text " This is a Javadoc comment with links to {@link [String]}, {@link [java.lang.Integer]}, and\n {@link [Inner]}.\n"

  //- @fieldOne defines/binding FieldOne
  private static int fieldOne; // inline comment here

  //- FieldTwoDoc documents FieldTwo
  //- FieldTwoDoc.node/kind doc
  //- !{ FieldTwoDoc.subkind AnySubkind }
  //- FieldTwoDoc.text "fieldTwo represents the universe"
  //- @+3fieldTwo defines/binding FieldTwo

  // fieldTwo represents the universe
  private static String fieldTwo;

  //- @+3fieldThree defines/binding FieldThree
  //- @+3fieldFour defines/binding FieldFour

  private static int fieldThree; // EOL comment
  private static int fieldFour;

  //- FieldThreeDoc documents FieldThree
  //- FieldThreeDoc.node/kind doc
  //- FieldThreeDoc.text "EOL comment"
  //- !{ FieldFourDoc documents FieldFour }

  //- @+3fieldFive defines/binding FieldFive
  //- @+2fieldSix defines/binding FieldSix

  private static int fieldFive, fieldSix; // EOL comment both

  //- FieldBothInlineDoc documents FieldFive
  //- FieldBothInlineDoc documents FieldSix
  //- FieldBothInlineDoc.text "EOL comment both"

  //- @+4fieldSeven defines/binding FieldSeven
  //- @+3fieldEight defines/binding FieldEight

  // above comment both
  private static int fieldSeven, fieldEight;

  //- FieldBothAboveDoc documents FieldSeven
  //- FieldBothAboveDoc documents FieldEight
  //- FieldBothAboveDoc.text "above comment both"
  
  //- InnerDoc documents InnerClass
  //- InnerDoc.node/kind doc
  //- InnerDoc.text "This comments the Inner class."
  //- @+3Inner defines/binding InnerClass

  // This comments the Inner class.
  public static class Inner {}

  //- InnerIDoc documents InnerI
  //- InnerIDoc.node/kind doc
  //- InnerIDoc.text "This comments the InnerI interface."
  //- InnerIWeirdDoc documents InnerI
  //- InnerIWeirdDoc.node/kind doc
  //- InnerIWeirdDoc.text "a second, weirdly-placed comment"
  //- @+3InnerI defines/binding InnerI

  /* This comments the InnerI interface. */ // a second, weirdly-placed comment
  static interface InnerI {} // this also comments the interface

  //- @+3InnerE ref/doc InnerE
  //- @+3InnerE defines/binding InnerE

  /** This comments the {@link InnerE} enum. */
  static enum InnerE {

    //- InnerEDoc documents InnerE
    //- InnerEDoc.node/kind doc
    //- InnerEDoc param.0 InnerE
    //- InnerEDoc.text "This comments the {@link [InnerE]} enum. "

    //- SomeValDoc documents SomeValue
    //- SomeValDoc.node/kind doc
    //- SomeValDoc.text "This comments SOME_VALUE."
    //- @+3SOME_VALUE defines SomeValue

    // This comments SOME_VALUE.
    SOME_VALUE,

    //- AnotherValDoc documents AnotherValue
    //- AnotherValDoc.node/kind doc
    //- AnotherValDoc.text "This documents {@link [ANOTHER_VALUE]}. "
    //- @+3ANOTHER_VALUE defines AnotherValue

    /** This documents {@link ANOTHER_VALUE}. */
    ANOTHER_VALUE;
  }

  //- ToStringDoc documents ToString
  //- ToStringDoc.node/kind doc
  //- ToStringDoc.text "This documents {@link [#toString()]}. "
  //- @+3toString defines/binding ToString

  /** This documents {@link #toString()}. */
  @Override public String toString() { return "null"; }

  //- @+4compareTo defines/binding CompareTo

  /** This documents {@link #compareTo()} over {@link Override}. */
  @Override
  public int compareTo(Comments o) { return 0; }
  //- OverrideDoc documents CompareTo
  //- OverrideDoc.node/kind doc
  //- OverrideDoc param.0 Override
  //- OverrideDoc.text "This documents {@link #compareTo()} over {@link [Override]}. "
}
