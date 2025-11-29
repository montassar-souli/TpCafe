package tn.esprit.spring.tpcafemontassarsouli.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
// La classe : Aspect
public class AspectClass {
    // La methode : Advice
    // @Before : avant l'execution de la methode cible
    // @After : apres l'execution de la methode cible
    // @AfterReturning : apres l'execution de la methode cible si elle retourne une valeur
    // @AfterThrowing : apres l'execution de la methode cible si elle lance une exception
    // @Around : autour de l'execution de la methode cible
    //@Before @After @AfterReturning @AfterThrowing @Around --> le type d'advice
    @Before("execution(* tn.esprit.spring.tpcafemontassarsouli.services.*.*(..))") // l'expression : JoinPoint (voir cours)
    // JoinPoint + type d'advice -> Pointcut
    public void logMethodEntry(JoinPoint joinPoint) {
        log.info("Hello from here "+joinPoint.getSignature().getName());
    }

    @After("execution(* tn.esprit.spring.tpcafemontassarsouli.services.*.*(..))") // l'expression : JoinPoint (voir cours)
    // JoinPoint + type d'advice -> Pointcut
    public void logMethodOut(JoinPoint joinPoint) {
        log.info("Byyyye from here "+joinPoint.getSignature().getName());
    }
}
