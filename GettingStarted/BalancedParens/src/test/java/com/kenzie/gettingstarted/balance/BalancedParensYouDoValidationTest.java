package com.kenzie.gettingstarted.balance;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BalancedParensYouDoValidationTest {

    BalancedParensTest baseTest = new BalancedParensTest();

    @ParameterizedTest
    @MethodSource("youDoValidationCases")
    void youDoBalancedParensTest(String input, boolean expected) {
        baseTest.youDoBalancedParensTest(input, expected);
    }

    static Stream<Arguments> youDoValidationCases() {
        return Stream.concat(BalancedParensWeDoValidationTest.weDoValidationCases(), Stream.of(
            Arguments.of("{[(():]]}", false),
            Arguments.of("{[(():])]}", true),
            Arguments.of("{[(())]}():}", true),
            Arguments.of("{[(())]}():]", true),
            Arguments.of("{[(())]}():)", true),
            Arguments.of(":{{[(())]}()", true),
            Arguments.of(":[{[(())]}()", true),
            Arguments.of(":({[(())]}()", true),
            Arguments.of(":)", true),
            Arguments.of(":]", true),
            Arguments.of(":}", true),
            Arguments.of("::}", true),
            Arguments.of("{functions: [ lambda: (x,y) -> (x * (x + y)); ]} (json)", true),
            Arguments.of("{functions:[lambda:(x,y)->(x*(x+y));]}(no winkey smileys :()", false),
            Arguments.of("{functions:[lambda(x,y)->(x*(x+y)):]}(bad syntax but good balance)", true),
            Arguments.of(":({[(())]}()trailing text", true),
            Arguments.of("groupless text", true)
        ));
    }
}
