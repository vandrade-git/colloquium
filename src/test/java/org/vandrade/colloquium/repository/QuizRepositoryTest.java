package org.vandrade.colloquium.repository;

import java.util.Collection;
import java.util.UUID;

import com.github.paulcwarren.ginkgo4j.Ginkgo4jConfiguration;
import com.github.paulcwarren.ginkgo4j.Ginkgo4jSpringRunner;
import org.jooq.DSLContext;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import org.vandrade.colloquium.generated.Tables;
import org.vandrade.colloquium.generated.tables.pojos.Quiz;
import org.vandrade.colloquium.repository.impl.QuizRepository;

import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.AfterEach;
import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.BeforeEach;
import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.Context;
import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.Describe;
import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.It;
import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.JustBeforeEach;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Author: Vitor Andrade
 * Date: 12/6/21
 * Time: 1:15 PM
 */

@SuppressWarnings("ALL")
@RunWith(Ginkgo4jSpringRunner.class)
@Ginkgo4jConfiguration(threads = 1)
@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class QuizRepositoryTest {
    // Fields >>
    @Autowired
    private DSLContext jooq;

    @Autowired
    private QuizRepository quizRepository;

    private Quiz retSingle;
    private Collection<Quiz> retCollection;
    private Boolean retExists;
    private Long retCount;
    private Exception retException;
    // << Fields

    {
        Describe("QuizRepository test", () -> {
            It("QuizRepository bean should not be null", () -> {
                assertThat(quizRepository, notNullValue());
            });

            BeforeEach(() -> {
//                jooq.insertInto(Tables.TEST, Tables.TEST.CONTENTS)
//                        .values("contents")
//                        .execute();

//                quizRepository.generate();
            });

            AfterEach(() -> {
                jooq.truncate(Tables.QUIZ).cascade().execute();
                jooq.execute("DELETE FROM sqlite_sequence WHERE name='quiz';");
            });

            /*
             * Find One
             */
            Context("findOne <id: Int>", () -> {
                JustBeforeEach(() -> {
                    try {
                        retSingle = quizRepository.findOne(1);
                    } catch (Exception exception) {
                        retException = exception;
                    }
                });

                Context("when a valid Quiz entity exists", () -> {
                    BeforeEach(() -> {
                        quizRepository.generate(UUID.randomUUID().toString());
                    });

                    It("should return a valid Quiz entity", () -> {
                        assertThat(retSingle, notNullValue());
                        assertThat(retSingle.getId(), is(1));
                    });
                });

                Context("when a valid Quiz entity does not exist", () -> {
                    It("should return a null entity", () -> {
                        assertThat(retException, nullValue());
                    });
                });
            });
        });
    }


    @org.junit.Test
    public void noop() {
        // NO-OP
    }
}
