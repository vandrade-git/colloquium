package org.vandrade.colloquium.repository;

import java.util.Collection;

import com.github.paulcwarren.ginkgo4j.Ginkgo4jConfiguration;
import com.github.paulcwarren.ginkgo4j.Ginkgo4jSpringRunner;
import org.jooq.DSLContext;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import org.vandrade.colloquium.generated.Tables;
import org.vandrade.colloquium.generated.tables.pojos.QuestionTemplate;
import org.vandrade.colloquium.generated.tables.pojos.Quiz;
import org.vandrade.colloquium.repository.impl.QuestionRepository;
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
public class QuestionRepositoryTest {
    // Fields >>
    @Autowired
    private DSLContext jooq;

    @Autowired
    private QuestionRepository questionRepository;

    private QuestionTemplate retSingle;
    private Collection<QuestionTemplate> retCollection;
    private Boolean retExists;
    private Long retCount;
    private Exception retException;
    // << Fields

    {
        Describe("QuestionRepository test", () -> {
            It("QuestionRepository bean should not be null", () -> {
                assertThat(questionRepository, notNullValue());
            });

            /*
             * Find One
             */
            Context("findOne <id: Int>", () -> {
                JustBeforeEach(() -> {
                    try {
                        retSingle = questionRepository.findOne(1);
                    } catch (Exception exception) {
                        retException = exception;
                    }
                });

                Context("when a valid QuestionTemplate entity exists", () -> {
                    It("should return a valid Question entity", () -> {
                        assertThat(retSingle, notNullValue());
                        assertThat(retSingle.getId(), is(1));
                        assertThat(retSingle.getContents(), is("Question 1"));
                    });
                });

                Context("when a valid QuestionTemplate entity does not exist", () -> {
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
