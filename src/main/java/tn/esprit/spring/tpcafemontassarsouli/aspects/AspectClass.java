package tn.esprit.spring.tpcafemontassarsouli.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
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

    @Before("execution(* tn.esprit.spring.tpcafemontassarsouli.services.*.*(..))")
    public void logServiceMethodEntry(JoinPoint joinPoint) {
        log.info("Bienvenue à l'un des services de l'application Boycott : Service -->"+joinPoint.getSignature().getDeclaringType().getSimpleName()+" Method -->"+joinPoint.getSignature().getName());
    }

    @Before("execution(* tn.esprit.spring.tpcafemontassarsouli.restcontrollers.*.ajouter*(..))")
    public void logBeforeAjouterMethod(JoinPoint joinPoint) {
        String packageName = joinPoint.getSignature().getDeclaringType().getPackage().getName();
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        log.info("=== AVANT EXÉCUTION ===");
        log.info("Package: {}", packageName);
        log.info("Classe: {}", className);
        log.info("Méthode: {}", methodName);
        log.info("======================");
    }
    //

    @AfterReturning("execution(* tn.esprit.spring.tpcafemontassarsouli.restcontrollers.*.ajouter*(..))")
    public void logAfterAjouterMethod(JoinPoint joinPoint) {
        String packageName = joinPoint.getSignature().getDeclaringType().getPackage().getName();
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        log.info("=== APRÈS EXÉCUTION (SUCCÈS) ===");
        log.info("Package: {}", packageName);
        log.info("Classe: {}", className);
        log.info("Méthode: {}", methodName);
        log.info("==============================");
    }

    // "execution(* * tn.esprit.spring.tpcafemontassarsouli.services.*.*(..))"
    // --> 1ere * : visiteur (modificateur d'acces : public, private, protected, default)(optionnel)
    // --> 2eme * : type de retour (tous les types de retour)
    // --> 3eme * : nom de la classe (toutes les classes)
    // --> 4eme * : nom de la methode (toutes les methodes)
    // --> (..) : tous les parametres possibles

    // Exemples d'expressions pointcut :
    // "execution(* tn.esprit.spring.tpcafemontassarsouli.services..*.*(..))"
    // --> tous les service methods + sous packages

    // "execution(public * *(..))"
    // --> toutes les methodes publiques

    // "execution(* * set*(..))"
    // --> toutes les methodes setters

    // "execution(* tn.esprit.spring.tpcafemontassarsouli.services..*.*(String))"
    // --> toutes les methodes qui ont un parametre de type String

    // "execution(* tn.esprit.spring.tpcafemontassarsouli.services..*.*(String,..))"
    // --> toutes les methodes qui ont un 1er parametre de type String


}
